package repositories;

import lombok.var;
import models.Directors;
import models.Model;

import javax.persistence.TypedQuery;

public class DirectorRepository implements ModelRepository {
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
        return entityManager.find(Directors.class, id);
    }

    @Override
    public Model findByName(String name) {
        var entityManager = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Directors> query = entityManager.createQuery("SELECT obj FROM Movie obj WHERE obj.title = :name", Directors.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
