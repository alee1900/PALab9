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
@Table(name = "movie_genre")
public class MovieGenre extends Model {
    @Column(name = "movieId", length = 10, nullable = false, unique = true)
    int movieID;
    @Column(name = "genreId", length = 10, nullable = false, unique = true)
    int genreID;

    public MovieGenre() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = 0;
        this.genreID = 0;
    }

    public MovieGenre(int movieID, int genreID) {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = movieID;
        this.genreID = genreID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
