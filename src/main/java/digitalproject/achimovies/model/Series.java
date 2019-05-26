package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="Series")
public class Series extends AbstractEntity {
    @Column(name="series_name")
    private String seriesName;
    @Column(name="year")
    private int year;
    @Column(name="rate")
    private double rate;

    @Column(name="artist")
    @ManyToMany
    @JoinTable(name="series_artist",joinColumns = @JoinColumn(name="series_id"),
            inverseJoinColumns =@JoinColumn(name="artist_id"))
    @JsonBackReference
    private Set<Artist> artists;

    @ManyToOne
    @JsonIgnore
    private Director director;

    @Column(name="country")
    @Enumerated(EnumType.STRING)
    Country country;

    @ManyToMany
    @JoinTable(name="series_language",joinColumns = @JoinColumn(name="series_id"),
            inverseJoinColumns =@JoinColumn(name="language_id"))
    @JsonIgnore
    private Set<Language>languages;

    @ManyToMany
    @JoinTable(name="series_genre",joinColumns = @JoinColumn(name="series_id"),
            inverseJoinColumns =@JoinColumn(name="genre_id"))
    @JsonIgnore
    private Set<Genre>genres;

    public Series() {
    }
}
