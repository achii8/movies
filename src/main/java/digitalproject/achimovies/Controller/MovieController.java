package digitalproject.achimovies.Controller;

import digitalproject.achimovies.Repository.ArtistRepository;
import digitalproject.achimovies.Repository.LanguageRepository;
import digitalproject.achimovies.Repository.MovieRepository;
import digitalproject.achimovies.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LanguageRepository languageRepository;


    @PostMapping("/create")
    private Movie create(@Valid @RequestBody Movie movieModel) {
        if (movieModel != null && movieModel.getId() == null) {
            movieRepository.save(movieModel);
        }
        return null;
    }
    @PostMapping("/update")
    private Movie update(@RequestBody Movie movieModel) {
        if (movieModel != null && movieModel.getId() != null) {
            if (movieRepository.findById(movieModel.getId()).isPresent()) {
                movieRepository.save(movieModel);
            }
            movieRepository.save(movieModel);
        }
        return null;
    }

    @GetMapping("/read/{id}")
    private Movie read(@PathVariable("id") Long id) {
        Movie movie=movieRepository.getById(id);
        if(movie!=null){
            return movie;
        }
        return null;
    }

    @GetMapping("/cast/{id}")
    private Set<Artist> cast(@PathVariable("id")Long id){
        Optional<Movie>movieOptional=movieRepository.findById(id);
        if(movieOptional.isPresent()){
            Set<Artist>artists;
            artists=movieOptional.get().getArtists();
            return artists;
        }
        return null;
    }

    @GetMapping("/language/{id}")
    private Set<Movie> getAllbyLanguges(@PathVariable("id") Language language){
        Set<Movie>movies=new HashSet<>();
        movies.addAll(movieRepository.findAllByLanguages(language));
        if(movies!=null){
            return movies;
        }
        return null;
    }
    @GetMapping("/genre/{id}")
    private Set<Movie>getAllByGenres(@PathVariable("id") Genre genre){
        Set<Movie>movies=new HashSet<>();
        movies.addAll(movieRepository.findAllByGenres(genre));
        if(movies!=null){
            return movies;
        }
        return null;
    }

    @PostMapping("/delete/{id}")
    private boolean delete(@PathVariable("id") Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            movieRepository.delete(movieOptional.get());
            return true;
        }
        return false;
    }
    @GetMapping("/getAllByRate/{rate}")
    private Set<Movie> findMoviesByrate(@PathVariable("rate") Double rate){
        Set<Movie> movies=movieRepository.findAllByRate(rate);
        if(movies!=null){
            return movies;
        }
        return null;
    }

    @GetMapping("/moviesyears/{year1}/{year2}")
    private Set<Movie> moviesYearsBetween(@PathVariable int year1, @PathVariable int year2){
        Set<Movie>movies=movieRepository.findAllByYearBetween(year1,year2);
        if(movies!=null){
            return movies;
        }
        return null;

    }

    @GetMapping("/director/{id}")
    private Set<Movie> findMoviesByDirector(@PathVariable("id") Director director){
        Set<Movie>movies=movieRepository.findAllByDirector(director);
        if(movies!=null){
            return movies;
        }
        return null;
    }

    /**
     * ვისი ვისაშია?
     *
     * @param id
     * @return
     */

    @GetMapping("/similars/{id}")
    private Set<Movie> findthreesimilar(@PathVariable("id") Long id){
        Set<Genre> genre=movieRepository.getById(id).getGenres();
        Genre g=genre.iterator().next();
        Set<Movie>movies=movieRepository.findAllByGenres(g);
        Set<Movie>movielist=new HashSet<>();
        int counter=0;
        for(Movie e :movies){
            movielist.add(e);
            counter++;
            if(counter==3)
                break;
        }
        if(movielist!=null){
            return movielist;
        }
        return null;

    }





}
