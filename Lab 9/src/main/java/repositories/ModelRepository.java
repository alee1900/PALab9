package repositories;

import models.Model;

/**
 * ModelRepository interface for repository classes
 */
public interface ModelRepository {
    void create(Model object);

    Model findById(int id);

    Model findByName(String name);
}
