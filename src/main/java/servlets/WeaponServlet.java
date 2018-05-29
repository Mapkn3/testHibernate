package servlets;

import entities.WeaponEntity;
import org.hibernate.Session;
import utils.EntityDao;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Weapon")
public class WeaponServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("entity", null);
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try (Session session = new HibernateUtil().getSession()) {
                EntityDao dao = new EntityDao(session);
                long id = Long.parseLong(idParam);
                WeaponEntity entity = (WeaponEntity) dao.readEntity(WeaponEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/weapon.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            Long attackBonus = Long.valueOf(req.getParameter("attackBonus"));
            Long criticalBonus = Long.valueOf(req.getParameter("criticalBonus"));
            String type = req.getParameter("type");
            Long range = Long.valueOf(req.getParameter("range"));
            String damage = req.getParameter("countDice") + req.getParameter("typeDice");
            WeaponEntity entity = (WeaponEntity) dao.readEntity(WeaponEntity.class, id);
            if (entity == null) {
                entity = new WeaponEntity();
                entity.setId(id);
                entity.setName(name);
                entity.setAttackBonus(attackBonus);
                entity.setCriticalBonus(criticalBonus);
                entity.setTypeOfWeapon(type);
                entity.setRangeOfWeapon(range);
                entity.setDamage(damage);
                dao.createEntity(entity);
            } else {
                entity.setName(name);
                entity.setAttackBonus(attackBonus);
                entity.setCriticalBonus(criticalBonus);
                entity.setTypeOfWeapon(type);
                entity.setRangeOfWeapon(range);
                entity.setDamage(damage);
                dao.updateEntity(entity);
            }
        }
        resp.sendRedirect("entities?type=Weapon&action=show");
    }
}
