package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="genre")
public class Genre extends AbstractEntity {
    private String genre;

    @ManyToMany(mappedBy="genres")
    @JsonBackReference
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private Set<Series>series;

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }
}
