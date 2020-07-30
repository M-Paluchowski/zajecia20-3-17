import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalExample {

    @Test
    void optionalCreation() {
        String name = "Marcin";
        Optional<String> nameOptional = Optional.of(name);

        String nameTwo = null;
        Optional<String> nameOptionalTwo = Optional.ofNullable(nameTwo);

        System.out.println(nameOptional.isPresent());
        System.out.println(nameOptionalTwo.isPresent());

        String getOne = nameOptional.get();
        System.out.println(getOne);

        if (nameOptionalTwo.isPresent()) {
            String getTwo = nameOptionalTwo.get();
            System.out.println(getTwo);
        }
    }

    @Test
    void optionOrElse() {
        Optional<Integer> integer = Optional.of(1);
        Optional<Integer> empty = Optional.empty();

        Integer integerOrElse = integer.orElse(0);
        System.out.println(integerOrElse);

        Integer integerTwoOrElse = empty.orElse(0);
        System.out.println(integerTwoOrElse);
    }
}
