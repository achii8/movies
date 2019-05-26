package digitalproject.achimovies.Service;

import digitalproject.achimovies.Repository.LanguageRepository;
import digitalproject.achimovies.Repository.MovieRepository;
import digitalproject.achimovies.model.Language;
import digitalproject.achimovies.model.Movie;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieService {
    MovieRepository movieRepository;
    LanguageRepository languageRepository;

}
