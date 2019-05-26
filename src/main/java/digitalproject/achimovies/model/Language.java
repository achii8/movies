package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="languages")
public class Language extends AbstractEntity {
    @Column(name="language")
    private String language;
    @ManyToMany(mappedBy = "languages")
    private Set<Movie> movie;

    @ManyToMany(mappedBy = "languages")

    private Set<Series>series;

    public Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public Language() {
    }
}
