package grep;

import grep.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            int choice = menu();
            String pattern = pattern();
            String file = file();
            if (choice == 1) {
                try {
                    GrepSingle.run(pattern, file);
                } catch (IOException | InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (choice == 2) {
                try {
                    GrepMultiThreaded.run(pattern, file);
                } catch (IOException | InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println("Try again? (type exit to quit)");
        } while (!userInput.nextLine().equals("exit"));
    }

    static int menu() {
        System.out.println("Multi or single threaded?");
        System.out.println("1. Single");
        System.out.println("2. Multi");
        return userInput.nextInt();
    }

    static String pattern() {
        System.out.println("Enter pattern to search for (regex)");
        userInput.nextLine();
        return userInput.nextLine();
    }

    static String file() {
        System.out.println("Enter path to file");
        return userInput.nextLine();
    }
}
