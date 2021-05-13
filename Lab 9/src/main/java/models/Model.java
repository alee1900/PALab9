package models;

import lombok.Data;

import javax.persistance.Column;

@Data
public abstract class Model {
    @Column(name = "ID", length = 10, nullable = false, unique = false)
    int id;

    Model(int id) {
        this.id = id;
    }
}
