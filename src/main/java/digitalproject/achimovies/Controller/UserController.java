package digitalproject.achimovies.Controller;

import digitalproject.achimovies.Repository.MovieRepository;
import digitalproject.achimovies.Service.UserService;
import digitalproject.achimovies.data.DTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/register")
    public ResponseEntity addUser(@Valid @RequestBody UserDto data){return userService.addUser(data);
    }


}
