package digitalproject.achimovies.Repository;



import digitalproject.achimovies.model.Director;
import digitalproject.achimovies.model.Genre;
import digitalproject.achimovies.model.Language;
import digitalproject.achimovies.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie getById(Long id);
    Set<Movie>findAllByYearBetween(int year1, int year2);
    Set<Movie>findAllByRate(double rate);
    Set<Movie> findAllByLanguages(Language language);
    Set<Movie>findAllByGenres(Genre genre);
    Set<Movie>findAllByDirector(Director director);

}
