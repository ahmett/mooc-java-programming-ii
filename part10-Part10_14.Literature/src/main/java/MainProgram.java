
import java.util.*;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.parseInt(scanner.nextLine());

            books.add(new Book(name, ageRecommendation));
            System.out.println();
        }

        System.out.println(books.size() + " books in total.\n");

        System.out.println("Books: ");

        Comparator<Book> comparator = Comparator.comparing(Book::getAgeRecommendation).thenComparing(Book::getName);
        books.sort(comparator);

        for (Book book : books) {
            System.out.println(book);
        }
    }

}
