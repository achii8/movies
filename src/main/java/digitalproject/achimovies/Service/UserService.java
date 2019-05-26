package digitalproject.achimovies.Service;

import digitalproject.achimovies.Repository.MovieRepository;
import digitalproject.achimovies.Repository.UserRepository;
import digitalproject.achimovies.data.DTO.ResponseDTO;
import digitalproject.achimovies.data.DTO.UserDto;
import digitalproject.achimovies.exception.DublicateException;
import digitalproject.achimovies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;
    public ResponseEntity addUser(UserDto data){
        if (userRepository.findByUsername(data.getUsername()) != null) {
            throw new DublicateException("Username Already Exists!");
        }
        User newUser = userRepository.save(
                User.builder().fullname(data.getFullname())
                        .username(data.getUsername())
                        .password(data.getPassword()).build());
        return ResponseEntity.ok(ResponseDTO.builder()
                .success(true)
                .content(newUser)
                .build());

    }

}
