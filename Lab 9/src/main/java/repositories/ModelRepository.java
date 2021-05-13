package repositories;

import models.Model;

public interface ModelRepository {
    void create(Model object);

    Model findById(int id);

    Model findByName(String name);
}
