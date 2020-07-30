package examples.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UsersDatabase usersDatabase = new UsersDatabase();
//        User user = usersDatabase.getUser("abc@gmail.com");
//        String firstName = user.getFirstName();
//        System.out.println(firstName);

        Optional<User> userTwoOptional = usersDatabase.getUser("cba@gmail.com");
        if (userTwoOptional.isPresent()) {
            User userTwo = userTwoOptional.get();
            String usersTwoFirstName = userTwo.getFirstName();
            System.out.println(usersTwoFirstName);
        }
    }
}
