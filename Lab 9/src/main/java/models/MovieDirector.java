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
 * MovieDirector class for movie_director DB
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movie_director")
public class MovieDirector extends Model {
    @Column(name = "movieId", length = 10, nullable = false, unique = true)
    int movieID;
    @Column(name = "directorId", length = 10, nullable = false, unique = true)
    int directorID;

    public MovieDirector() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = 0;
        this.directorID = 0;
    }

    public MovieDirector(int movieID, int directorID) {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = movieID;
        this.directorID = directorID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
