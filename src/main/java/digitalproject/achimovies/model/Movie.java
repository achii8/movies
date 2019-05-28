package digitalproject.achimovies.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import digitalproject.achimovies.data.Enum.Country;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@Table(name="movies")
public class Movie extends AbstractEntity {

    @Column(name="movie_name")
    private String movieName;
    @Column(name="year")
    private int year;

    @Column(name="rate")
    private double rate;


    @Column(name="artist")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="movie_artist",joinColumns = @JoinColumn(name="movie_id"),
    inverseJoinColumns =@JoinColumn(name="artist_id"))
    @JsonIgnore
    private Set<Artist>artists;

    @ManyToOne
    @JsonIgnore
    private Director director;

    @Column(name="country")
    @Enumerated(EnumType.STRING)
    Country country;

    /**
     * მინდოდა ენა და ჟანრი Enum ტიპის ყოფილიყო, მაგრამ ერთ კინოს როცა რამდენიმე ენას ვანიჭებდი,
     * რომელიმე Collection მჭირდებოდა და მერე @Enumerated ანოტაციის დადების უფლებას არ მაძლევდა.
     * მიწერდა, რომ ეს ანოტაცია Enum ტიპს ეკუთვნოდა და Set ან List არ იყო ენამი; :(
     *
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="movie_language",joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns =@JoinColumn(name="language_id"))
    @JsonIgnore
    private Set<Language>languages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="movie_genre",joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns =@JoinColumn(name="genre_id"))
    @JsonIgnore
    private Set<Genre>genres;


    public Movie(String movieName, int year, Double rate, Country country) {
        this.movieName = movieName;
        this.year = year;
        this.rate = rate;
        this.country = country;
    }

    public Movie(String movieName, int year, double rate, Set<Artist> artists,
                 Director director, Country country, Set<Language> languages, Set<Genre> genres) {
        this.movieName = movieName;
        this.year = year;
        this.rate = rate;
        this.artists = artists;
        this.director = director;
        this.country = country;
        this.languages = languages;
        this.genres = genres;
    }

    public Movie() {
    }
}
