package servlets;

import entities.PlayerEntity;
import org.hibernate.Session;
import utils.EntityDao;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Player")
public class PlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("entity", null);
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try (Session session = new HibernateUtil().getSession()) {
                EntityDao dao = new EntityDao(session);
                long id = Long.parseLong(idParam);
                PlayerEntity entity = (PlayerEntity) dao.readEntity(PlayerEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/player.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao<PlayerEntity> dao = new EntityDao<>(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String status = req.getParameter("status");
            List<PlayerEntity> entities = dao.getAll(PlayerEntity.class);
            PlayerEntity entity = dao.readEntity(PlayerEntity.class, id);
            if (entity == null) {
                if (entities.stream().anyMatch(x -> x.getName().equals(name))) {
                    resp.sendRedirect("pages/errors/playerErrorPage.jsp?errorMessage=Incorrect+login");
                } else {
                    entity = new PlayerEntity();
                    entity.setId(id);
                    entity.setName(name);
                    entity.setPassword(password);
                    entity.setStatus(status);
                    entity.setPersonages(null);
                    dao.createEntity(entity);
                    resp.sendRedirect("pages/Yarik.jsp");
                }
            } else {
                resp.sendRedirect("pages/errors/playerErrorPage.jsp?errorMessage=Incorrect+id");
            }
        }
    }
}
