import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args)  {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emFactory.createEntityManager();

        Engine engine = new Engine(entityManager);
        engine.run();
    }
}