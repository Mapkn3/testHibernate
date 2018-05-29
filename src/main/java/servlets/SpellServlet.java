package servlets;

import entities.PersonageClassEntity;
import entities.SpellEntity;
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

@WebServlet("/Spell")
public class SpellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("entity", null);
        String idParam = req.getParameter("id");
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            List<PersonageClassEntity> personageClasses = dao.getAll(PersonageClassEntity.class);
            req.getSession().setAttribute("classes", personageClasses);
            if (idParam != null) {
                long id = Long.parseLong(idParam);
                SpellEntity entity = (SpellEntity) dao.readEntity(SpellEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/spell.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            long classId = Long.parseLong(req.getParameter("class"));
            SpellEntity entity = (SpellEntity) dao.readEntity(SpellEntity.class, id);
            PersonageClassEntity personageClass = (PersonageClassEntity) dao.readEntity(PersonageClassEntity.class, classId);
            if (entity == null) {
                entity = new SpellEntity();
                entity.setId(id);
                entity.setName(name);
                entity.setDescription(description);
                entity.setPersonageClass(personageClass);
                dao.createEntity(entity);
            } else {
                entity.setName(name);
                entity.setDescription(description);
                entity.setPersonageClass(personageClass);
                dao.updateEntity(entity);
            }
        }
        resp.sendRedirect("entities?type=Spell&action=show");
    }
}
