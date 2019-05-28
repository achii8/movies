package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
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


    @ManyToMany(mappedBy = "artists",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Movie>movies=new HashSet<>();

    @ManyToMany(mappedBy = "artists",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Series>series;

    public Artist(String artistFullName, int age, boolean hasOscars) {
        this.artistFullName = artistFullName;
        this.age = age;
        this.hasOscars = hasOscars;
    }

    public Artist() {
    }
}
