import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("hospital_database");
        EntityManager em = emf.createEntityManager();

    }
}
