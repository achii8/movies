package digitalproject.achimovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name="user")
public class User extends AbstractEntity {
    @Column(name="fullname")
    private String fullname;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;


    public User() {
    }
}
