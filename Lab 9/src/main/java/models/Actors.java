package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static java.lang.Integer.valueOf;

/**
 * Actors class for actors DB
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "actors")
public class Actors extends Model {
    @Column(name = "name", length = 10, nullable = false, unique = true)
    String name;

    public Actors() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        name = null;
    }

    public Actors(String name) {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
