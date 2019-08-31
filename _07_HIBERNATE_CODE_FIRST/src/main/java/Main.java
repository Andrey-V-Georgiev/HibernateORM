import ingredients.abstractClasses.BasicIngredient;
import ingredients.classes.AmmoniumChloride;
import ingredients.classes.Mint;
import ingredients.classes.Nettle;
import labels.classes.BasicLabel;
import shampoos.abstractClasses.BasicShampoo;
import shampoos.classes.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shampoos");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label = new BasicLabel("Fresh Nuke",
                "Contains mint and nettle");
        BasicShampoo shampoo = new FreshNuke(label);
        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        em.persist(shampoo);

        em.getTransaction().commit();
        em.close();
    }
}
