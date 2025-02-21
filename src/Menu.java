/**
 * Jacob Whitney
 * Software Development I
 * February 23, 2025
 * Menu.java
 * --Description: Manages CLI menu and user interactions
 */

// Imports
import java.util.Scanner;

public class Menu {
    // Custom Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static int getValidId(Scanner scanner) {
        int id;
        System.out.print("ID: ");
        while (true) {
            // Validate input is an integer
            if (scanner.hasNextInt()) { // --need to validate for user entering ctrl+d/ctrl+z, it means end the input, but shouldn't quit the program
                id = scanner.nextInt();

                // Validate input meets id constraints
                if (id >= 1 && id <= 10) { // --Change to check for duplicates
                    scanner.nextLine();
                    break;
                } else {
                    System.out.print("Please enter an integer between 1 and 10: ");
                }
            } else {
                System.out.print("Please enter an integer: ");
                scanner.next();
            }
        }
        return id;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String getValidName(Scanner scanner) {
        String name;
        System.out.print("Name: ");
        while (true) {
            // Validate input is a string
            name = scanner.nextLine();
            // Validate input meets name constraints
            if (name.length() < 2) {
                System.out.print("Enter a name with 2 characters or more: ");
            } else if (name.length() > 50) {
                System.out.print("Enter a name with 50 characters or less: ");
            } else {
                break;
            }
        }
        return name;
    }
}
