import java.util.Objects;
import javax.persistence.*;

/**
 * Singleton class responsible with the management of an EntityManagerFactory object
 */
public class EntityManager {
    INSTANCE;

    @PersistenceContext
    private EntityManager entityManager = null;
    @PersistenceUnit(name = "persistenceUnit")
    private EntityManagerFactory entityManagerFactory = null;

    void createEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (entityManager == null)
            createEntityManager();
        return entityManager;
    }

    public void closeEntityManager() {
        if (entityManager != null)
            if (Objects.requireNonNull(entityManager).isOpen()) {
                entityManager.close();
            }
        entityManager = null;

        if (entityManagerFactory != null)
            if (Objects.requireNonNull(entityManagerFactory).isOpen()) {
                entityManagerFactory.close();
            }
        entityManagerFactory = null;
    }
}
