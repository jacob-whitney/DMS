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

// Imports
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Initialize variables
        CharacterList list = new CharacterList();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Interactive menu
        while (loop) {
            String input = sc.nextLine();
            switch (input) {
                case "i":
                    // Import characters
                    ArrayList<String> importList = Menu.readFile("resources/char-3.txt");
                    for (int i = 0; i < importList.size(); i++) {
                        System.out.println(importList.get(i));
                    }
                    break;
                case "c":
                    // Create character

                    // User inputs id
                    // Validate id to meet constraints
                    // Check id for duplicates
                    // int id gets valid ID



                    int id = Menu.getValidId(Menu.inputAttribute("id", sc), list, sc);
                    String name = Menu.getValidName(sc);
                    String classification = Menu.getValidClassification(sc);
                    String race = Menu.getValidRace(sc);
                    int str = Menu.getValidAbilityScore("str", sc);
                    int dex = Menu.getValidAbilityScore("dex", sc);
                    int con = Menu.getValidAbilityScore("con", sc);


                    System.out.println("Creating character:"); // --will need to be print headers and print values below on one line
                    System.out.println("- ID: " + id);
                    System.out.println("- Name: " + name);
                    System.out.println("- Class: " + classification);
                    System.out.println("- Race: " + race);
                    System.out.println("- Strength: " + str);
                    System.out.println("- Dexterity: " + dex);
                    System.out.println("- Constitution: " + con);

                    list.addCharacter(new Character(id, name, classification, race, str, dex, con));
                    break;
                case "p":
                    System.out.println(list.getCharacterList());
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