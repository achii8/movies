package digitalproject.achimovies.data.DTO;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class UserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String fullname;
    @NotEmpty
    private String password;
}
