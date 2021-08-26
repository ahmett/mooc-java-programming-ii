
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            inputs.add(input);
        }

        for (String input : inputs) {
            System.out.println(input);
        }
    }
}
