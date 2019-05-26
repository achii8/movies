package digitalproject.achimovies.devbootstrap;


import digitalproject.achimovies.Repository.*;
import digitalproject.achimovies.data.Enum.Country;
import digitalproject.achimovies.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MovieBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private GenreRepository genreRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Artist> artists=new HashSet<>();
        artists.add(new Artist("achi",21,true));
        artists.add(new Artist("tilda",20,true));
        artistRepository.saveAll(artists);
        Director dir=new Director("lanabanana",23,true);
        directorRepository.save(dir);

        Language French=new Language("French");

        Set<Language>languages= new HashSet<>();
        languages.add(new Language("Georgian"));
        languages.add(new Language("English"));
        languages.add(French);
        languageRepository.saveAll(languages);

        Set<Genre>genres=new HashSet<>();
        genres.add(new Genre("horror"));
        genres.add(new Genre("drama"));
        genreRepository.saveAll(genres);


        Movie movie=new Movie("avengers",2019,20,artists,dir,Country.France,languages,genres);
        movieRepository.save(movie);

        movieRepository.save(new Movie("achis cxovreba",2068,1000,artists,dir,Country.Georgia,languages,genres));


        Set<Artist>cast=new HashSet<>();
        cast.add(artistRepository.getById(1L));
        cast.add(artistRepository.getById(2L));
        Movie mother=new Movie("Mother",2000,10,cast,dir,Country.USA,languages,genres);
        movieRepository.save(mother);


    }
}
