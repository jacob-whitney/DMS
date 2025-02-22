/**
 * Jacob Whitney
 * Software Development I
 * February 23, 2025
 * Menu.java
 * --Description: Manages CLI menu and user interactions
 */

// Imports
import java.util.Objects;
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
        while (true) { // --add checking for duplicates
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

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String getValidClassification(Scanner scanner) {
        String input;
        String classification = "None selected";

        System.out.println("Choose from one of the following classes:");
        System.out.println("1. Barbarian");
        System.out.println("2. Fighter");
        System.out.println("3. Ranger");
        System.out.println("4. Rogue");
        System.out.println("5. Sorcerer");
        System.out.println("6. Warlock");
        System.out.println("7. Wizard");
        System.out.println();
        System.out.print("Enter class: ");

        boolean loop = true;
        while (loop) {
            input = scanner.nextLine();
            switch (input) {
                case "1", "Barbarian", "barbarian":
                    classification = "Barbarian";
                    loop = false;
                    break;
                case "2", "Fighter", "fighter":
                    classification = "Fighter";
                    loop = false;
                    break;
                case "3", "Ranger", "ranger":
                    classification = "Ranger";
                    loop = false;
                    break;
                case "4", "Rogue", "rogue":
                    classification = "Rogue";
                    loop = false;
                    break;
                case "5", "Sorcerer", "sorcerer":
                    classification = "Sorcerer";
                    loop = false;
                    break;
                case "6", "Warlock", "warlock":
                    classification = "Warlock";
                    loop = false;
                    break;
                case "7", "Wizard", "wizard":
                    classification = "Wizard";
                    loop = false;
                    break;
                default:
                    System.out.print("Enter a valid classification: ");
            }
        }
        return classification;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String getValidRace(Scanner scanner) {
        String input;
        String race = "None selected";

        System.out.println("Choose from one of the following races:");
        System.out.println("1. Dwarf");
        System.out.println("2. Dragonborn");
        System.out.println("3. Elf");
        System.out.println("4. Gnome");
        System.out.println("5. Halfling");
        System.out.println("6. Human");
        System.out.println();
        System.out.print("Enter class: ");

        boolean loop = true;
        while (loop) {
            input = scanner.nextLine();
            switch (input) {
                case "1", "Dwarf", "dwarf":
                    race = "Dwarf";
                    loop = false;
                    break;
                case "2", "Dragonborn", "dragonborn":
                    race = "Dragonborn";
                    loop = false;
                    break;
                case "3", "Elf", "elf":
                    race = "Elf";
                    loop = false;
                    break;
                case "4", "Gnome", "gnome":
                    race = "Gnome";
                    loop = false;
                    break;
                case "5", "Halfling", "halfling":
                    race = "Halfling";
                    loop = false;
                    break;
                case "6", "Human", "human":
                    race = "Human";
                    loop = false;
                    break;
                default:
                    System.out.print("Enter a valid race: ");
            }
        }
        return race;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static int getValidAbilityScore(String ability, Scanner scanner) {
        int score;
        if (ability.equals("str")) {
            System.out.print("Strength: ");
        } else if (ability.equals("dex")) {
            System.out.print("Dexterity: ");
        } else if (ability.equals("con")) {
            System.out.print("Constitution: ");
        } else {
            System.out.println("Not a valid ability");
        }
        while (true) {
            // Validate input is an integer
            if (scanner.hasNextInt()) { // --need to validate for user entering ctrl+d/ctrl+z, it means end the input, but shouldn't quit the program
                score = scanner.nextInt();

                // Validate input meets id constraints
                if (score >= 3 && score <= 20) { // --Change to check for duplicates
                    scanner.nextLine();
                    break;
                } else {
                    System.out.print("Please enter an integer from 3 to 20: ");
                }
            } else {
                System.out.print("Please enter an integer: ");
                scanner.next();
            }
        }
        return score;
    }
}
