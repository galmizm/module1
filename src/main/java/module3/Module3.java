package module3;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.Math;

public class Module3 {

    public static class Book{
        String name;
        Integer price;

        public Book(String name, Integer price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book A1", 100));
        bookList.add(new Book("Book A2", 110));
        bookList.add(new Book("Book B1", 100));
        bookList.add(new Book("Book B2", 120));
        bookList.add(new Book("Book a1", 150));
        bookList.add(new Book("Book C", 150));
        bookList.add(new Book("Book D", 130));
        bookList.add(new Book("Book E", 100));
        bookList.add(new Book("Book1", 100));
        bookList.add(new Book("Book2", 100));
        bookList.add(new Book("Book3", 100));
        bookList.add(new Book("Book4", 100));
        bookList.add(new Book("Book BB", 120));
        bookList.add(new Book("Book BB", 100));
        bookList.add(new Book("Book BB", 150));

        System.out.println(bookList);

        bookList.stream()
                .forEach(System.out::println);

        List<String> booksNames = bookList.stream()
                .map(book -> book.getName())
                .collect(Collectors.toList());

        System.out.println(booksNames);

        Integer totalPrice = bookList.stream()
                .map(book -> book.getPrice())
                .reduce(0, (acc, x) -> acc + x);

        System.out.println(totalPrice);

        bookList.stream()
                .filter(book -> book.getName().contains("A") || book.getName().contains("a"))
                .forEach(System.out::println);

        Optional<Integer> higherPriceBook = bookList.stream()
                .map(book -> book.getPrice())
                .reduce((acc, x) -> Math.max(acc, x));

        System.out.println(higherPriceBook);

        Comparator<Book> comparator = Comparator.comparing(Book::getPrice);

        Book higherPriceBook2 = bookList.stream()
                .max(comparator)
                .get();

        System.out.println(higherPriceBook2);

        int numberOfFiveLengthBook = bookList.stream()
                .collect(Collectors.groupingBy((book)-> book.getName().length()))
                .entrySet()
                .stream()
                .filter(lenght -> lenght.getKey() == 5)
                .map(entry -> entry.getValue().size())
                .reduce(0, (acc, x) -> acc + x);

        System.out.println(numberOfFiveLengthBook);

        List<Book> cheaperThan130 = bookList.stream()
                .filter(book -> book.getPrice() < 130)
                .collect(Collectors.toList());

        System.out.println(cheaperThan130);

        List<Book> sortedList = bookList.stream()
                .sorted(Comparator.comparing(Book::getName, Comparator.reverseOrder()).thenComparing(Book::getPrice, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        System.out.println(sortedList);

    }
}
