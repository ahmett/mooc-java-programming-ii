
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < fromWhere || i >= toWhere) {
                continue;
            }

            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            }
        }

        return sum;
    }

}
