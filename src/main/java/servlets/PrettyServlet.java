package servlets;

import entities.PersonageEntity;
import entities.PrettyEntity;
import entities.WeaponEntity;
import entities.WeaponOfPersonageEntity;
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

@WebServlet("/entities")
public class PrettyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            String type = req.getParameter("type");
            String action = req.getParameter("action");
            Class entityClass = Class.forName("entities." + type + "Entity");
            switch (action) {
                case "show":
                    List entities = dao.getAll(entityClass);
                    if (type.equals("Personage")) {
                        for (Object entity : entities) {
                            ((PersonageEntity)entity).calculateMod();
                        }
                    }
                    req.getSession().setAttribute("entities", entities);
                    req.getSession().setAttribute("metadata", entityClass);
                    req.getRequestDispatcher("pages/show.jsp").forward(req, resp);
                    break;
                case "delete":
                    Long id = Long.valueOf(req.getParameter("id"));
                    PrettyEntity entity = dao.readEntity(entityClass, id);
                    if (entity != null) {
                        if (type.equals("Personage")) {
                            for (WeaponOfPersonageEntity weaponOfPersonage : ((PersonageEntity)entity).getWeapons()) {
                                dao.deleteEntity(weaponOfPersonage);
                            }
                        }
                        dao.deleteEntity(entity);
                    }
                    //resp.sendRedirect(req.getContextPath() + "/entities?action=show&type=" + type);
                    resp.sendRedirect(req.getContextPath()+"/index.jsp");
                    break;
                case "edit":
                    resp.sendRedirect(req.getContextPath() + "/" + type + "?id=" + req.getParameter("id"));
                    break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
