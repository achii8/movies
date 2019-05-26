package digitalproject.achimovies.Repository;

import digitalproject.achimovies.model.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director,Long> {

}
