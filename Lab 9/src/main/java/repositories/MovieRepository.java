package repositories;

import lombok.var;
import models.Movies;
import models.Model;

import javax.persistence.TypedQuery;

public class MovieRepository implements ModelRepository {
    @Override
    public void create(Model object) {
        var entityManager = EntityManagerSingleton.INSTANCE.getEntityManager();
        if (object.getId() == null) {
            entityManager.persist(object);
        }
    }

    @Override
    public Model findById(int id) {
        var entityManager = EntityManagerSingleton.INSTANCE.getEntityManager();
        return entityManager.find(Movies.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Movies> query = entityManager.createQuery("SELECT obj FROM Movie obj WHERE obj.title = :name", Movies.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}