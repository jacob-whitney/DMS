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
            System.out.print(Menu.printMainMenu());
            String input = sc.nextLine();

            switch (input) {
                case "i":
                    // Import characters
                    System.out.println();
                    System.out.println("Importing characters by file");
                    System.out.print("---------------------------------");
                    System.out.println("-------------------------------");

                    ArrayList<String> importChars = Menu.readFile(Menu.inputFilePath());
                    String charLine = "";

                    System.out.println();
                    System.out.println("Characters created:");
                    System.out.println(Menu.printCharHeadings());

                    for (int i = 0; i < importChars.size(); i++) {
                        charLine = importChars.get(i);
                        if (Menu.validateImportedString(charLine)) {
                            list.addCharacter(Menu.parseAttributesFromString(charLine, list));
                        }
                    }
                    System.out.println();
                    break;

                case "p":
                    // Print characters
                    System.out.println();
                    System.out.println("Characters");
                    System.out.print("---------------------------------");
                    System.out.println("-------------------------------");

                    System.out.println(Menu.printCharHeadings());
                    System.out.println(list.getCharacterList());
                    break;

                case "c":
                    // Create character
                    System.out.println();
                    System.out.println("Create a Character");
                    System.out.print("---------------------------------");
                    System.out.println("-------------------------------");

                    int id = Menu.getValidId(Menu.inputAttribute("id"), list);
                    String name = Menu.getValidName(Menu.inputAttribute("name"), list);
                    String classification = Menu.getValidClassification(Menu.inputAttribute("classification"));
                    String race = Menu.getValidRace(Menu.inputAttribute("race"));
                    int str = Menu.getValidAbilityScore("str", Menu.inputAttribute("str"));
                    int dex = Menu.getValidAbilityScore("dex", Menu.inputAttribute("dex"));
                    int con = Menu.getValidAbilityScore("con", Menu.inputAttribute("con"));

                    System.out.println();
                    System.out.println("Character created:");
                    System.out.println(Menu.printCharHeadings());
                    System.out.print(id + " | " + name + " | " + classification + " | ");
                    System.out.println(race + " |  " + str + "  |  " + dex + "  |  " + con);
                    System.out.println();

                    list.addCharacter(new Character(id, name, classification, race, str, dex, con));
                    break;

                case "d":
                    // Delete character
                    System.out.println();
                    System.out.println("Delete a Character");
                    System.out.print("---------------------------------");
                    System.out.println("-------------------------------");

                    System.out.println(Menu.printCharHeadings());
                    System.out.println(list.getCharacterList());
                    System.out.println();
                    System.out.println("Enter the ID of the character you wish to delete");

                    list.deleteCharacter(Menu.inputAttribute("id"));

                    System.out.println();
                    System.out.println(Menu.printCharHeadings());
                    System.out.println(list.getCharacterList());

                    break;

                case "q":
                    System.out.println();
                    System.out.println("Program terminated.");
                    loop = false;
                    break;

                default:
                    System.out.println("> Invalid input, please try again");
            }

        }
    }
}