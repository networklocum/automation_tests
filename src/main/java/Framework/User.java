package Framework;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    public String Email;

    @Getter
    @Setter
    public String Password;

    public User(String email, String password) {
        Email = email;
        Password = password;
    }
}
