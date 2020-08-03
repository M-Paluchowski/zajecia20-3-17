import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    private int multiplierTwo = 4;

    @Test
    void createEmptyStream() {
        Stream<Integer> empty = Stream.empty();
    }

    @Test
    void createStreamOf() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    @Test
    void createStreamCollections() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = integers.stream();
    }

    @Test
    void createStreamConcat() {
        Stream<Integer> first = Stream.of(1, 2, 3);
        Stream<Integer> second = Stream.of(9, 10, 11);
        Stream<Integer> concat = Stream.concat(first, second);
        concat.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    void streamForEach() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        integers.stream()
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    @Test
    void streamFilterInteger() {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6, 7, 8);
        integers.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer number) {
                        return number % 2 == 0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
        System.out.println(integers);
    }

    @Test
    void streamFilterString() {
        Stream.of("Ala", "Agata", "Jarek", "Kamil")
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("a");
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });
    }

    @Test
    void streamMapInteger() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer number) {
                        return number * 2;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer number) {
                        System.out.println(number);
                    }
                });
    }

    @Test
    void streamMapPerson() {
        Set<String> names = Set.of("Ania", "Kamil", "Jarek");
        names.stream()
                .map(new Function<String, Person>() {
                    @Override
                    public Person apply(String name) {
                        return new Person(name);
                    }
                })
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return person.getFirstName().contains("i");
                    }
                })
                .forEach(new Consumer<Person>() {
                    @Override
                    public void accept(Person person) {
                        System.out.println(person);
                    }
                });
    }

    @Test
    void streamCollectIntegers() {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer number) {
                        return number * 2;
                    }
                })
                .collect(Collectors.toList());
//                .collect(Collectors.toSet());

        System.out.println(collect);
    }

    @Test
    void streamForEachLambda() {
        // f(x) = x * 2
        // f(2) = 2 * 2 = 4
        // f(3) = 3 * 2 = 6

        // f(x) = x * 2
        // (x) -> x * 2
        // x -> x * 2

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        integers.stream()
                .forEach(number -> System.out.println(number));
    }

    @Test
    void streamIterateAndLimit() {
        Stream.iterate(0, number -> number + 1)
                .limit(10)
                .forEach(number -> System.out.println(number));
    }

    @Test
    void streamTakeWhile() {
        List<String> names = List.of("Ania", "Kamil", "Jarek", "Marcin");
        List<String> namesWithoutJ = names.stream()
                .takeWhile(name -> !name.contains("J"))
                .collect(Collectors.toList());
        System.out.println(namesWithoutJ);
    }

    @Test
    void streamMethodReference() {
        Stream.of("Ania", "Kamil", "Jarek")
//                .forEach(name -> System.out.println(name));
                .forEach(System.out::println);
    }

    @Test
    void streamMethodReferenceOnDeclaredMethod() {
        Stream.of("Ania", "Kamil", "Jarek")
                .filter(this::containsI)
                .forEach(System.out::println);
    }

    @Test
    void streamMethodReferenceOnDeclaredStaticMethod() {
        Stream.of("Ania", "Kamil", "Jarek")
                .filter(StreamExamples::containsIStatic)
                .forEach(System.out::println);
    }

    @Test
    void streamPeek() {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .peek(number -> System.out.println(number * 2))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamPeekWithMultiplier() {
        int multiplier = 2;
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .peek(number -> System.out.println(number * multiplier * multiplierTwo))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamCount() {
        long count = Stream.iterate(1, number -> number * 2)
                .limit(100)
                .count();

        System.out.println(count);
    }

    @Test
    void streamFlatMap() {
        List<Human> users = List.of(new Human("Ania", List.of(new Address("Wrocław", "Polska"), new Address("Praga", "Czechy"))),
                new Human("Jarek", List.of(new Address("Berlin", "Niemcy"))),
                new Human("Iza", List.of(new Address("Warszawa", "Polska"))));

        List<String> cities = users.stream()
                .flatMap(user -> user.getAddresses().stream())
                .map(Address::getCity)
                .collect(Collectors.toList());

        System.out.println(cities);
    }

    @Test
    void streamSortedNatural() {
        List<Integer> collect = Stream.of(9, 8, 7, 6, 5, 4, 3, 2, 1)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamSortedWithComparator() {
        List<Human> users = List.of(new Human("Ania", List.of(new Address("Wrocław", "Polska"), new Address("Praga", "Czechy"))),
                new Human("Jarek", List.of(new Address("Berlin", "Niemcy"))),
                new Human("Iza", List.of(new Address("Warszawa", "Polska"))));

        List<Human> collect = users.stream()
                .sorted((humanOne, humanTwo) -> humanOne.getFirstName().compareTo(humanTwo.getFirstName()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamSortedWithComparatorShort() {
        List<Human> users = List.of(new Human("Ania", List.of(new Address("Wrocław", "Polska"), new Address("Praga", "Czechy"))),
                new Human("Jarek", List.of(new Address("Berlin", "Niemcy"))),
                new Human("Iza", List.of(new Address("Warszawa", "Polska"))));

        List<Human> collect = users.stream()
                .sorted(Comparator.comparing(Human::getFirstName)/*.reversed()*/)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamAllMatch() {
        List<Human> users = List.of(new Human("Ania", List.of(new Address("Wrocław", "Polska"), new Address("Praga", "Czechy"))),
                new Human("Jarek", List.of(new Address("Berlin", "Niemcy"))),
                new Human("Iza", List.of(new Address("Warszawa", "Polska"))));

        boolean allMatch = users.stream()
//                .anyMatch()
//                .noneMatch()
                .allMatch(human -> human.getFirstName().endsWith("a"));

        System.out.println(allMatch);
    }

    @Test
    void streamDistinct() {
        List<String> names = List.of("Ania", "Jarek", "Karol", "Ania", "Karo", "Ania", "Jarek");

        List<String> distinctNames = names.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctNames);
    }

    private boolean containsI(String name) {
        return name.contains("i");
    }

    private static boolean containsIStatic(String name) {
        return name.contains("i");
    }

    class Human {
        private String firstName;
        private List<Address> addresses;

        public Human(String firstName, List<Address> addresses) {
            this.firstName = firstName;
            this.addresses = addresses;
        }

        public String getFirstName() {
            return firstName;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "firstName='" + firstName + '\'' +
                    ", addresses=" + addresses +
                    '}';
        }
    }

    class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    class Person {
        private String firstName;

        public Person(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    '}';
        }
    }
}
