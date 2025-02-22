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
        CharacterList list = new CharacterList();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Interactive menu
        while (loop) {
            String input = sc.nextLine();
            switch (input) {
                case "i":
                    // Import characters

                    break;
                case "c":
                    // Create character
                    int id = Menu.getValidId(sc);
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