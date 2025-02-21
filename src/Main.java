import java.util.Scanner;

/**
 * Jacob Whitney
 * Software Development I
 * February 23, 2025
 * Main.java
 * Description: Users can create Characters to be played in their
 * Dungeons & Dragon's games. Each Character has unique
 * attributes. The program adheres to the following requirements:
 * - Character class holds at least 6 attributes
 * - User must be able to perform CRUD operations
 * - User must be able to perform a custom action: Roll ability score stats
 * - User must never be able to crash the program by entering invalid data
 * - The program only exits when the user chooses to
 */
public class Main {
    public static void main(String[] args) {
        // Initialize variables
        int count = 0;
        CharacterList list = new CharacterList();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Interactive menu
        while (loop) {
            String input = sc.nextLine();
            switch (input) {
                case "c":
                    // Create patron

                    // print instructions
                    // user input
                    // if validateId is true
                    // id = input

                    // Each input function validates before returning value

                    int id = Menu.getValidId(sc);
                    String name = Menu.getValidName(sc);
                    /*String classification = Menu.getValidClassification(sc);
                    String race = getValidRace(sc);
                    int str = getValidStr(sc);
                    int dex = getValidDex(sc);
                    int con = getValidCon(sc);
                    */

                    System.out.println("Creating character:");
                    System.out.println("- ID: " + id);
                    System.out.println("- Name: " + name);
                    /*System.out.println("- Class: " + classification);
                    System.out.println("- Race: " + race);
                    System.out.println("- Strength: " + str);
                    System.out.println("- Dexterity: " + dex);
                    System.out.println("- Constitution: " + con);
                     */

                    /*
                    list[count] = new Character(id, name, classification, race, str, dex, con);
                    count++;
                    */
                    break;
                case "q":
                    System.out.println("Quitting program...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }

        }
    }
}