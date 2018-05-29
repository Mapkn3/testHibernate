package servlets;

import entities.PersonageClassEntity;
import org.hibernate.Session;
import utils.EntityDao;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PersonageClass")
public class PersonageClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("entity", null);
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try (Session session = new HibernateUtil().getSession()) {
                EntityDao dao = new EntityDao(session);
                long id = Long.parseLong(idParam);
                PersonageClassEntity entity = (PersonageClassEntity) dao.readEntity(PersonageClassEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/personageClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            String features = req.getParameter("features");
            Long maxHp = Long.valueOf(req.getParameter("maxHp"));
            String researchAcrobatics = req.getParameter("researchAcrobatics");
            String researchBluff = req.getParameter("researchBluff");
            String researchPerception = req.getParameter("researchPerception");
            String researchDiplomacy = req.getParameter("researchDiplomacy");
            String researchSpellcraft = req.getParameter("researchSpellcraft");
            Long baseAttackBonus = Long.valueOf(req.getParameter("baseAttackBonus"));
            PersonageClassEntity entity = (PersonageClassEntity) dao.readEntity(PersonageClassEntity.class, id);
            if (entity == null) {
                entity = new PersonageClassEntity();
                entity.setId(id);
                entity.setName(name);
                entity.setFeatures(features);
                entity.setMaxHp(maxHp);
                entity.setResearchAcrobatics(researchAcrobatics);
                entity.setResearchBluff(researchBluff);
                entity.setResearchPerception(researchPerception);
                entity.setResearchDiplomacy(researchDiplomacy);
                entity.setResearchSpellcraft(researchSpellcraft);
                entity.setBaseAttackBonus(baseAttackBonus);
                dao.createEntity(entity);
            } else {
                entity.setName(name);
                entity.setFeatures(features);
                entity.setMaxHp(maxHp);
                entity.setResearchAcrobatics(researchAcrobatics);
                entity.setResearchBluff(researchBluff);
                entity.setResearchPerception(researchPerception);
                entity.setResearchDiplomacy(researchDiplomacy);
                entity.setResearchSpellcraft(researchSpellcraft);
                entity.setBaseAttackBonus(baseAttackBonus);
                dao.updateEntity(entity);
            }
        }
        resp.sendRedirect("entities?type=PersonageClass&action=show");
    }
}
