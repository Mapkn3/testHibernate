package servlets;

import entities.RaceEntity;
import org.hibernate.Session;
import utils.EntityDao;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Race")
public class RaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try (Session session = new HibernateUtil().getSession()) {
                EntityDao dao = new EntityDao(session);
                long id = Long.parseLong(idParam);
                RaceEntity entity = (RaceEntity) dao.readEntity(RaceEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/race.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            String size = req.getParameter("size");
            Long speed = Long.valueOf(req.getParameter("speed"));
            String features = req.getParameter("features");
            RaceEntity entity = (RaceEntity) dao.readEntity(RaceEntity.class, id);
            if (entity == null) {
                entity = new RaceEntity();
                entity.setId(id);
                entity.setName(name);
                entity.setSize(size);
                entity.setSpeed(speed);
                entity.setFeatures(features);
                dao.createEntity(entity);
            } else {
                entity.setName(name);
                entity.setSize(size);
                entity.setSpeed(speed);
                entity.setFeatures(features);
                dao.updateEntity(entity);
            }
        }
        resp.sendRedirect("entities?type=Race&action=show");
    }
}
