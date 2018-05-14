package servlets;

import entities.*;
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

@WebServlet("/Personage")
public class PersonageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            List<PersonageClassEntity> personageClasses = dao.getAll(PersonageClassEntity.class);
            List<RaceEntity> races = dao.getAll(RaceEntity.class);
            List<PlayerEntity> players = dao.getAll(PlayerEntity.class);
            List<WeaponEntity> weapons = dao.getAll(WeaponEntity.class);
            req.getSession().setAttribute("classes", personageClasses);
            req.getSession().setAttribute("races", races);
            req.getSession().setAttribute("players", players);
            req.getSession().setAttribute("weapons", weapons);
            if (idParam != null) {
                long id = Long.parseLong(idParam);
                PersonageEntity entity = (PersonageEntity) dao.readEntity(PersonageEntity.class, id);
                req.getSession().setAttribute("entity", entity);
            }
        }
        req.getRequestDispatcher("pages/personage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            Long xp = Long.valueOf(req.getParameter("xp"));
            Long level = PersonageEntity.calculateLevel(xp);
            String alignment = req.getParameter("alignment");
            String characteristics = req.getParameter("characteristics");
            long classId = Long.parseLong(req.getParameter("class"));
            long raceId = Long.parseLong(req.getParameter("race"));
            long weapon1Id = Long.parseLong(req.getParameter("weapon1"));
            long weapon2Id = Long.parseLong(req.getParameter("weapon2"));
            long weapon3Id = Long.parseLong(req.getParameter("weapon3"));
            long ownerId = Long.parseLong(req.getParameter("player"));
            PersonageClassEntity personageClass = (PersonageClassEntity) dao.readEntity(PersonageClassEntity.class, classId);
            RaceEntity race = (RaceEntity) dao.readEntity(RaceEntity.class, raceId);
            WeaponEntity weapon1 = (WeaponEntity) dao.readEntity(WeaponEntity.class, weapon1Id);
            WeaponEntity weapon2 = (WeaponEntity) dao.readEntity(WeaponEntity.class, weapon2Id);
            WeaponEntity weapon3 = (WeaponEntity) dao.readEntity(WeaponEntity.class, weapon3Id);
            PlayerEntity owner = (PlayerEntity) dao.readEntity(PlayerEntity.class, ownerId);
            PersonageEntity entity = (PersonageEntity) dao.readEntity(PersonageEntity.class, id);
            if (entity == null) {
                entity = new PersonageEntity();
                entity.setId(id);
                entity.setName(name);
                entity.setXp(xp);
                entity.setLevel(level);
                entity.setAlignment(alignment);
                entity.setCharacteristics(characteristics);
                entity.setPersonageClass(personageClass);
                entity.setRace(race);
                entity.setOwner(owner);
                dao.createEntity(entity);
                WeaponOfPersonageEntity wop1 = new WeaponOfPersonageEntity();
                wop1.setId(1000000000L + entity.getId());
                wop1.setPersonage(entity);
                wop1.setWeapon(weapon1);
                WeaponOfPersonageEntity wop2 = new WeaponOfPersonageEntity();
                wop2.setId(2000000000L + entity.getId());
                wop2.setPersonage(entity);
                wop2.setWeapon(weapon2);
                WeaponOfPersonageEntity wop3 = new WeaponOfPersonageEntity();
                wop3.setId(3000000000L + entity.getId());
                wop3.setPersonage(entity);
                wop3.setWeapon(weapon3);
                dao.createEntity(wop1);
                dao.createEntity(wop2);
                dao.createEntity(wop3);
            } else {
                entity.setName(name);
                entity.setXp(xp);
                entity.setLevel(level);
                entity.setAlignment(alignment);
                entity.setCharacteristics(characteristics);
                entity.setPersonageClass(personageClass);
                entity.setRace(race);
                entity.setOwner(owner);
                dao.updateEntity(entity);
                WeaponOfPersonageEntity wop1 = (WeaponOfPersonageEntity) dao.readEntity(WeaponOfPersonageEntity.class, 1000000000L + entity.getId());
                wop1.setWeapon(weapon1);
                WeaponOfPersonageEntity wop2 = (WeaponOfPersonageEntity) dao.readEntity(WeaponOfPersonageEntity.class, 2000000000L + entity.getId());
                wop2.setWeapon(weapon2);
                WeaponOfPersonageEntity wop3 = (WeaponOfPersonageEntity) dao.readEntity(WeaponOfPersonageEntity.class, 3000000000L + entity.getId());
                wop3.setWeapon(weapon3);
                dao.updateEntity(wop1);
                dao.updateEntity(wop2);
                dao.updateEntity(wop3);
            }
        }
        resp.sendRedirect("entities?type=Personage&action=show");
    }
}
