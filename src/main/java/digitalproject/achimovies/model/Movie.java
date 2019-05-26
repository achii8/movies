package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import digitalproject.achimovies.data.Enum.Country;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Setter
@Table(name="movies")
public class Movie extends AbstractEntity {

    @Column(name="movie_name")
    private String movieName;
    @Column(name="year")
    private int year;

    @Column(name="movie_rate")
    private double rate;

    @Column(name="artist")
    @ManyToMany
    @JoinTable(name="movie_artist",joinColumns = @JoinColumn(name="movie_id"),
    inverseJoinColumns =@JoinColumn(name="artist_id"))
    @JsonIgnore
    private Set<Artist>artists;

    @ManyToOne
    @JsonIgnore
    private Director director;

    @Column(name="country")
    @Enumerated(EnumType.STRING)
    Country counrty;

    /**
     * მინდოდა ენა და ჟანრი Enum ტიპის ყოფილიყო, მაგრამ ერთ კინოს როცა რამდენიმე ენას ვანიჭებდი,
     * რომელიმე Collection მჭირდებოდა და მერე @Enumerated ანოტაციის დადების უფლებას არ მაძლევდა.
     * მიწერდა, რომ ეს ანოტაცია Enum ტიპს ეკუთვნოდა და Set ან List არ იყო ენამი; :(
     *
     */
    @ManyToMany
    @JoinTable(name="movie_language",joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns =@JoinColumn(name="language_id"))
    @JsonIgnore
    private Set<Language>languages;

    @ManyToMany
    @JoinTable(name="movie_genre",joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns =@JoinColumn(name="genre_id"))
    @JsonIgnore
    private Set<Genre>genres;

    public Movie(String movieName, int year, double rate, Country counrty) {
        this.movieName = movieName;
        this.year = year;
        this.rate = rate;
        this.counrty = counrty;
    }

    public Movie() {
    }
}
