import models.Actors;
import models.Genres;
import models.Movies;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager;
        entityManager = EntityManager.INSTANCE.getEntityManager();
        entityManager.getTransaction().begin();

        Movies movie = new Movies("Joker", "2019", 122, 8);
        Genres genre = new Genres("Crime");
        Actors actor = new Actors("Joaquin Phoenix");

        entityManager.persist(movie);
        entityManager.persist(genre);
        entityManager.persist(actor);

        entityManager.getTransaction().commit();
        EntityManager.INSTANCE.closeEntityManager();

        EntityManager.INSTANCE.closeEntityManager();
    }
}
