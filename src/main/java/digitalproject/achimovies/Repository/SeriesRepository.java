package digitalproject.achimovies.Repository;

import digitalproject.achimovies.model.Director;
import digitalproject.achimovies.model.Genre;
import digitalproject.achimovies.model.Language;
import digitalproject.achimovies.model.Series;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;


@Repository
public interface SeriesRepository extends CrudRepository<Series,Long> {
    Series getById(Long id);
    Set<Series>findAllByYearBetween(int year1, int year2);
    Set<Series>findAllByRate(double rate);
    Set<Series> findAllByLanguages(Language language);
    Set<Series>findAllByGenres(Genre genre);
    Set<Series> findAllByDirector(Director director);
}
