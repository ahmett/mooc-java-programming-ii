
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            numbers.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String choice = scanner.nextLine();

        double average = numbers
                .stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> filterFor(choice, i))
                .average()
                .getAsDouble();

        System.out.println("Average of the " + (choice.equals("p") ? "positive" : "negative") + " numbers: " + average);
    }

    public static boolean filterFor(String choice, int i) {
        if (choice.equals("p")) {
            return i > 0;
        }

        return i < 0;
    }
}
