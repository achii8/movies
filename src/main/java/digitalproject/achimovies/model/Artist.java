package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="artists")
public class Artist extends AbstractEntity {

    @Column(name="artist_name")
    private String artistFullName;
    @Column(name="artist_age")
    private int age;
    @Column(name="artist_oscars")
    private boolean hasOscars;


    @ManyToMany(mappedBy = "artists")
    @JsonBackReference
    private Set<Movie>movies=new HashSet<>();

    @ManyToMany(mappedBy = "artists")

    private Set<Series>series;

    public Artist(String artistFullName, int age, boolean hasOscars) {
        this.artistFullName = artistFullName;
        this.age = age;
        this.hasOscars = hasOscars;
    }

    public Artist() {
    }
}
