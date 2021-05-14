package repositories;

import lombok.var;
import models.Directors;
import models.Model;

import javax.persistence.TypedQuery;

/**
 * DirectorRepository class for directors
 * Implements ModelRepository interface
 */
public class DirectorRepository implements ModelRepository {
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
        return entityManager.find(Directors.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        TypedQuery<Directors> query = entityManager.createQuery("SELECT director FROM directors director WHERE director.name = :name", Directors.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
