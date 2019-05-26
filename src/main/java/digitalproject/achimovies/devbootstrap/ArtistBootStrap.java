package digitalproject.achimovies.devbootstrap;

import digitalproject.achimovies.Repository.ArtistRepository;
import digitalproject.achimovies.Repository.MovieRepository;
import digitalproject.achimovies.model.Artist;
import digitalproject.achimovies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class ArtistBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       Artist a=new Artist();
       a.setAge(12);
       a.setArtistFullName("sopo");
       a.setHasOscars(true);
       artistRepository.save(a);



    }
}
