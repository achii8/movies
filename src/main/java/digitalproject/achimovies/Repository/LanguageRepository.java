package digitalproject.achimovies.Repository;

import digitalproject.achimovies.model.Language;
import digitalproject.achimovies.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    Language findById(long id);
    Language findByLanguage(String language);

}
