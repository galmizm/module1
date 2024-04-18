package module3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Module3Task2 {

    public static class Person {
        String name;
        String surname;
        Integer price;

        public Person(String name, String surname, Integer price) {
            this.name = name;
            this.surname = surname;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Peter", "Patterson", 21));

        personList.add(new Person("Paul", "Walker", 31));

        personList.add(new Person("Steve", "Runner", 41));

        personList.add(new Person("Arnold", "", -1));

        personList.add(new Person(" ", "Stevenson", 19));

        personList.add(new Person(" ", "Stevenson", 19));

        personList.add(new Person(" ", "Stevenson", 19));

        personList.add(new Person(" Arnold", "Stevenson", 19));
        personList.add(null);

        personList.add(new Person("Aaron", "Bortnicker", 18));

        String uniqueStr = String.valueOf(personList.stream()
                        .filter(entry -> entry != null)
                .map(entry -> entry.name.toUpperCase())
                .map(entry -> entry.replaceAll(" ", ""))
                        .filter(entry -> entry.isEmpty()==false)
                        .collect(Collectors.toSet()));
        //          .distinct()
        //        .reduce((acc, x) -> acc + ", " + x));

        System.out.println(uniqueStr);

    }
}
