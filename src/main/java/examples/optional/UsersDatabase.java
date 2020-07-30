package examples.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsersDatabase {

    private Map<String, User> usersDatabase = new HashMap<>();

    public UsersDatabase() {
        usersDatabase.put("abc@gmail.com", new User("Marcin", "P"));
    }

    public Optional<User> getUser(String email) {
        return Optional.ofNullable(usersDatabase.get(email));
    }
}
