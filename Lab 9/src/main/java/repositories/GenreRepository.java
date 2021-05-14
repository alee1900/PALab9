package repositories;

import lombok.var;
import models.Genres;
import models.Model;

import javax.persistence.TypedQuery;

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
        TypedQuery<Genres> query = entityManager.createQuery("SELECT obj FROM Movie obj WHERE obj.title = :name", Genres.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
