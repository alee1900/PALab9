package repositories;

import lombok.var;
import models.Genres;
import models.Model;

import javax.persistence.TypedQuery;

/**
 * GenreRepository class for genres
 * Implements ModelRepository interface
 */
public class GenreRepository implements ModelRepository {
    @Override
    public void create(Model object) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        if (object.getId() == null) {
            entityManager.persist(object);
        }
    }

    @Override
    public Model findById(int id) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        return entityManager.find(Genres.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        TypedQuery<Genres> query = entityManager.createQuery("SELECT genre FROM genres genre WHERE genre.name = :name", Genres.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
