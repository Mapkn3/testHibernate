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
import java.util.stream.Collectors;

@WebServlet("/Yarik")
public class ServletYarika extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        StringBuilder path = new StringBuilder(req.getContextPath());
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao<PlayerEntity> dao = new EntityDao<>(session);
            PlayerEntity user = dao.getAll(PlayerEntity.class).stream()
                    .filter(x -> x.getName().equals(login) && x.getPassword().equals(password))
                    .collect(Collectors.toList()).get(0);
            req.getSession().setAttribute("userId", user.primaryKey());
            path.append("/index.jsp");
        } catch (IndexOutOfBoundsException e) {
            path.append("/pages/Yarik.jsp?m=Incorrect login/password");
        }
        resp.sendRedirect(path.toString());
    }
}
