package digitalproject.achimovies.devbootstrap;

import digitalproject.achimovies.Repository.*;
import digitalproject.achimovies.data.Enum.Country;
import digitalproject.achimovies.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeriesBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Genre>genres=new HashSet<>();
        genres.add(new Genre("fantasy"));
        genres.add(new Genre("Comedy"));
        genreRepository.saveAll(genres);

        Set<Language>languages=new HashSet<>();
        languages.add(new Language("Georgian"));
        languages.add(new Language("Italian"));
        languageRepository.saveAll(languages);

        Director dir=new Director("xavier",30,false);
        directorRepository.save(dir);

        Set<Artist>artists=new HashSet<>();
        artists.add(new Artist("achi",30,true));
        artists.add(new Artist("eva green",35,false));
        artistRepository.saveAll(artists);

        Series got=new Series("game of thrones",2010,-11,artists,dir,Country.USA,languages,genres);
        Series AHS=new Series("American Horror Stoty",2008,10,artists,dir,Country.UK,languages,genres);
        Series penny=new Series("Penny Dreadful",2016,8,artists,dir,Country.UK,languages,genres);
        Series glee=new Series("glee",2006,3,artists,dir,Country.Georgia,languages,genres);

        seriesRepository.save(got);
        seriesRepository.save(AHS);
        seriesRepository.save(penny);
        seriesRepository.save(glee);

    }
}
