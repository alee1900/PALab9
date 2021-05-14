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
 * Genres class for genres DB
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "genres")
public class Genres extends Model {
    @Column(name = "name", length = 10, nullable = false, unique = true)
    private final String name;

    public Genres() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        name = null;
    }

    public Genres(String name) {
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
