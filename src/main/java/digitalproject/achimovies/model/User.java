package digitalproject.achimovies.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
