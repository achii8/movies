package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="director")
public class Director extends AbstractEntity{
    @Column(name="director_name")
    private String directorFullName;
    @Column(name="director_age")
    private int age;
    @Column(name="hasOscars")
    private boolean hasOscars;

    @OneToMany(mappedBy = "director")
    @JsonBackReference
    private Set<Movie> movies=new HashSet<>();

    @OneToMany(mappedBy = "director",fetch = FetchType.EAGER)
    private Set<Series>Series;

    public Director() {
    }

    public Director(String directorFullName, int age, boolean hasOscars) {
        this.directorFullName = directorFullName;
        this.age = age;
        this.hasOscars = hasOscars;
    }
}
