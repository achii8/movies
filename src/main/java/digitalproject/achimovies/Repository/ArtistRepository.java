package digitalproject.achimovies.Repository;

import digitalproject.achimovies.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Artist getById(Long id);

}
