import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list , Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        loop:
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.print("Task: ");
                    String item = scanner.nextLine();

                    list.add(item);
                    continue loop;
                case "remove":
                    System.out.print("Which task was completed? ");
                    int task = Integer.parseInt(scanner.nextLine());

                    list.get(task);
                    list.remove(task);
                    continue loop;
                case "list":
                    list.print();
                    continue loop;
                case "stop":
                    break loop;
            }
        }
    }
}
