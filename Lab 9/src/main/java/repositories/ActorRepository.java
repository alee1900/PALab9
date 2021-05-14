package repositories;

import lombok.var;
import models.Actors;
import models.Model;

import javax.persistence.TypedQuery;

/**
 * ActorRepository class for actors
 * Implements ModelRepository interface
 */
public class ActorRepository implements ModelRepository {
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
        return entityManager.find(Actors.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManager.INSTANCE.getEntityManager();
        TypedQuery<Actors> query = entityManager.createQuery("SELECT actor FROM actors actor WHERE actor.name = :name", Actors.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
