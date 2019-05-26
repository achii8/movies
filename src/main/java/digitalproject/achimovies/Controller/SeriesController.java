package digitalproject.achimovies.Controller;

import digitalproject.achimovies.Repository.ArtistRepository;
import digitalproject.achimovies.Repository.SeriesRepository;
import digitalproject.achimovies.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    ArtistRepository artistRepository;

    @PostMapping("/create")
    private Series create(@RequestBody Series seriesModel) {
        if (seriesModel != null && seriesModel.getId() == null) {
            seriesRepository.save(seriesModel);
        }
        return null;
    }
    @PostMapping("/update")
    private Series update(@RequestBody Series seriesModel) {
        if (seriesModel != null && seriesModel.getId() != null) {
            if (seriesRepository.findById(seriesModel.getId()).isPresent()) {
                seriesRepository.save(seriesModel);
            }
            seriesRepository.save(seriesModel);
        }
        return null;
    }

    @GetMapping("/read/{id}")
    private Series read(@PathVariable("id") Long id) {
        Optional<Series> seriesOptional = seriesRepository.findById(id);
        if (seriesOptional.isPresent()) {
            return seriesOptional.get();
        }
        return null;
    }

    @GetMapping("/cast/{id}")
    private Set<Artist> cast(@PathVariable("id")Long id){
        Optional<Series>seriesOptional=seriesRepository.findById(id);
        if(seriesOptional.isPresent()){
            Set<Artist>artists;
            artists=seriesOptional.get().getArtists();
            return artists;
        }
        return null;
    }


    @PostMapping("/delete/{id}")
    private boolean delete(@PathVariable("id") Long id) {
        Optional<Series> seriesOptional = seriesRepository.findById(id);
        if (seriesOptional.isPresent()) {
            seriesRepository.delete(seriesOptional.get());
            return true;
        }
        return false;
    }

    @GetMapping("/language/{id}")
    private Set<Series> getAllbyLanguges(@PathVariable("id") Language language){
        Set<Series>series=new HashSet<>();
        series.addAll(seriesRepository.findAllByLanguages(language));
        if(series!=null){
            return series;
        }
        return null;
    }

    @GetMapping("/genre/{id}")
    private Set<Series>getAllByGenres(@PathVariable("id") Genre genre){
        Set<Series>series=new HashSet<>();
        series.addAll(seriesRepository.findAllByGenres(genre));
        if(series!=null){
            return series;
        }
        return null;
    }

    @GetMapping("/getAllByRate/{rate}")
    private Set<Series> findSeriesByrate(@PathVariable("rate") Double rate){
        Set<Series> series=seriesRepository.findAllByRate(rate);
        if(series!=null){
            return series;
        }
        return null;
    }
    @GetMapping("/moviesyears/{year1}/{year2}")
    private Set<Series> seriesYearsBetween(@PathVariable int year1, @PathVariable int year2){
        Set<Series>series=seriesRepository.findAllByYearBetween(year1,year2);
        if(series!=null){
            return series;
        }
        return null;
    }

    @GetMapping("/director/{id}")
    private Set<Series> findSeriesByDirector(@PathVariable("id") Director director){
        Set<Series>series=seriesRepository.findAllByDirector(director);
        if(series!=null){
            return series;
        }
        return null;
    }
    @GetMapping("/similars/{id}")
    private Set<Series> findthreesimilar(@PathVariable("id") Long id){
        Set<Genre> genre=seriesRepository.getById(id).getGenres();
        Genre g=genre.iterator().next();
        Set<Series>series=seriesRepository.findAllByGenres(g);
        Set<Series>seriesList=new HashSet<>();
        int counter=0;
        for(Series e :series){
            seriesList.add(e);
            counter++;
            if(counter==3)
                break;
        }
        if(seriesList!=null){
            return seriesList;
        }
        return null;

    }

}
