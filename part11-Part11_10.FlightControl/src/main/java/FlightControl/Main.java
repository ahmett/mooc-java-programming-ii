package FlightControl;


import FlightControl.Logic.FlightControl;
import FlightControl.UI.TextUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextUI textUI = new TextUI(new FlightControl(), scanner);

        textUI.start();
    }
}
