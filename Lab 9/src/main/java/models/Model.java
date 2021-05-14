package models;

import lombok.Data;

import javax.persistance.Column;

/**
 * Model class
 */
@Data
public abstract class Model {
    @Column(name = "ID", length = 10, nullable = false, unique = false)
    int id;

    Model(int id) {
        this.id = id;
    }
}
