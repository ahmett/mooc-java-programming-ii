
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        loop:
        while (true) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);

            switch (command) {
                case "add":
                    if (amount >= 100 || amount + firstContainer >= 100) {
                        firstContainer = 100;
                    } else {
                        if (amount > 0) {
                            firstContainer += amount;
                        }
                    }

                    continue loop;
                case "move":
                    if (amount > firstContainer) {
                        amount = firstContainer;
                        firstContainer = 0;
                    } else {
                        firstContainer -= amount;
                    }

                    if (amount + secondContainer >= 100) {
                        secondContainer = 100;
                    } else {
                        secondContainer += amount;
                    }

                    continue loop;
                case "remove":
                    if (amount >= 100 || amount > secondContainer) {
                        secondContainer = 0;
                    } else {
                        secondContainer -= amount;
                    }
            }
        }
    }

}
