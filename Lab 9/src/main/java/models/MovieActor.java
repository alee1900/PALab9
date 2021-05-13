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

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movie_actor")
public class MovieActor extends Model {
    @Column(name = "movieId", length = 10, nullable = false, unique = true)
    int movieID;
    @Column(name = "actorId", length = 10, nullable = false, unique = true)
    int actorID;

    public MovieActor() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = 0;
        this.actorID = 0;
    }

    public MovieActor(int movieID, int actorID) {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = movieID;
        this.actorID = actorID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
