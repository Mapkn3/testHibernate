import entities.PersonageClassEntity;
import entities.PlayerEntity;
import entities.RaceEntity;
import org.hibernate.Session;
import utils.EntityDao;
import utils.HibernateUtil;

public class Main {
    public static void main(final String[] args) {
        try (Session session = new HibernateUtil().getSession()) {
            EntityDao dao = new EntityDao(session);

            PlayerEntity player1 = new PlayerEntity();
            player1.setId(0);
            player1.setName("Mapkn3");
            dao.createEntity(player1);
            PlayerEntity player2 = new PlayerEntity();
            player2.setId(1);
            player2.setName("Mr_way");
            dao.createEntity(player2);
            PlayerEntity player3 = new PlayerEntity();
            player3.setId(2);
            player3.setName("H@ck3r");
            dao.createEntity(player3);

            RaceEntity race1 = new RaceEntity();
            race1.setId(0);
            race1.setName("Human");
            race1.setFeatures("Handy");
            race1.setSize("M");
            race1.setSpeed(30L);
            dao.createEntity(race1);
            RaceEntity race2 = new RaceEntity();
            race2.setId(1);
            race2.setName("Bird");
            race2.setFeatures("Fly");
            race2.setSize("S");
            race2.setSpeed(50L);
            dao.createEntity(race2);

            PersonageClassEntity personageClass = new PersonageClassEntity();
            personageClass.setId(0);
            personageClass.setName("worker");
            personageClass.setFeatures("lazy");
            dao.createEntity(personageClass);
        }
    }
}