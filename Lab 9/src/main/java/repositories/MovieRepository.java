package repositories;

import lombok.var;
import models.Movies;
import models.Model;

import javax.persistence.TypedQuery;

/**
 * MovieRepository class for movies
 * Implements ModelRepository interface
 */
public class MovieRepository implements ModelRepository {
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
        return entityManager.find(Movies.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        TypedQuery<Movies> query = entityManager.createQuery("SELECT movie FROM movies movie WHERE movie.title = :name", Movies.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
