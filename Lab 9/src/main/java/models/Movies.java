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
 * Movies class for movies DB
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movies")
public class Movies extends Model{
    @Column(name = "title", length = 10, nullable = false, unique = true)
    private final String title;
    @Column(name = "release_date", length = 10, nullable = false, unique = false)
    private final String releaseDate;
    @Column(name = "duration", length = 10, nullable = false, unique = false)
    private final int duration;
    @Column(name = "score", length = 10, nullable = false, unique = false)
    private final int score;

    public Movies() {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        title = null;
        releaseDate = null;
        duration = 0;
        score = 0;
    }

    public Movies(String title, String releaseDate, int duration, int score) {
        super(valueOf(String.valueOf(UUID.randomUUID())));
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
