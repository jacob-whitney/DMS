/**
 * Jacob Whitney
 * Software Development I
 * February 23, 2025
 * Menu.java
 * --Description: Manages CLI menu and user interactions
 */

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    // User Input Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String inputFilePath() {
        System.out.println("Enter the file path (ex. resources/chars.txt) you want to import");
        System.out.println("Filepath: ");
        return sc.nextLine();
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String inputAttribute(String attribute) {
        boolean loop = true;
        while (loop) {
            switch (attribute) {
                case "id":
                    System.out.print("ID: ");
                    loop = false;
                    break;
                case "name":
                    System.out.print("Name: ");
                    loop = false;
                    break;
                case "classification":
                    System.out.println();
                    System.out.println("Choose from one of the following classes.");
                    System.out.println("  1. Barbarian");
                    System.out.println("  2. Fighter");
                    System.out.println("  3. Ranger");
                    System.out.println("  4. Rogue");
                    System.out.println("  5. Sorcerer");
                    System.out.println("  6. Warlock");
                    System.out.println("  7. Wizard");
                    System.out.println();
                    System.out.print("Class: ");
                    loop = false;
                    break;
                case "race":
                    System.out.println();
                    System.out.println("Choose from one of the following races.");
                    System.out.println("  1. Dwarf");
                    System.out.println("  2. Dragonborn");
                    System.out.println("  3. Elf");
                    System.out.println("  4. Gnome");
                    System.out.println("  5. Halfling");
                    System.out.println("  6. Human");
                    System.out.println();
                    System.out.print("Race: ");
                    loop = false;
                    break;
                case "str":
                    System.out.print("Strength: ");
                    loop = false;
                    break;
                case "dex":
                    System.out.print("Dexterity: ");
                    loop = false;
                    break;
                case "con":
                    System.out.print("Constitution: ");
                    loop = false;
                    break;
                default:
                    System.out.println("Not a valid attribute, try again");
            }
        }
        return sc.nextLine();
    }

    // Process Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static ArrayList<String> readFile(String filepath) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(filepath));

            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return data;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static Character parseAttributesFromString(String line, CharacterList list) {
        String[] attributes = line.split(", ");
        int id = 0;
        String name = "";
        String classification = "";
        String race = "";
        int str = 0;
        int dex = 0;
        int con = 0;

        switch (attributes.length) {
            case 7:
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(attributes[2]);
                race = getValidRace(attributes[3]);
                str = Integer.parseInt(attributes[4]);
                dex = Integer.parseInt(attributes[5]);
                con = Integer.parseInt(attributes[6]);
                break;
            case 6:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(attributes[2]);
                race = getValidRace(attributes[3]);
                str = Integer.parseInt(attributes[4]);
                dex = Integer.parseInt(attributes[5]);
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
            case 5:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(attributes[2]);
                race = getValidRace(attributes[3]);
                str = Integer.parseInt(attributes[4]);
                dex = getValidAbilityScore("dex", inputAttribute("dex"));
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
            case 4:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(attributes[2]);
                race = getValidRace(attributes[3]);
                str = getValidAbilityScore("str", inputAttribute("str"));
                dex = getValidAbilityScore("dex", inputAttribute("dex"));
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
            case 3:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(attributes[2]);
                race = getValidRace(inputAttribute("race"));
                str = getValidAbilityScore("str", inputAttribute("str"));
                dex = getValidAbilityScore("dex", inputAttribute("dex"));
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
            case 2:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(attributes[1], list);
                classification = getValidClassification(inputAttribute("classification"));
                race = getValidRace(inputAttribute("race"));
                str = getValidAbilityScore("str", inputAttribute("str"));
                dex = getValidAbilityScore("dex", inputAttribute("dex"));
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
            case 1:
                System.out.println("> Not all attributes were complete, please re-enter the following.");
                id = getValidId(attributes[0], list);
                name = getValidName(inputAttribute("name"), list);
                classification = getValidClassification(inputAttribute("classification"));
                race = getValidRace(inputAttribute("race"));
                str = getValidAbilityScore("str", inputAttribute("str"));
                dex = getValidAbilityScore("dex", inputAttribute("dex"));
                con = getValidAbilityScore("con", inputAttribute("con"));
                break;
        }

        return new Character(id, name, classification, race, str, dex, con);
    }

    // Validation Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean validateImportedString(String line) {
        String[] data = line.split(", ");
        if (data.length > 7) {
            System.out.println("> There are too many comma delimiters, this line will be skipped");
            return false;
        } else if (data.length < 1) {
            System.out.println("> No attributes detected, this line will be skipped");
            return false;
        } else {
            return true;
        }
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean validateId(String id) {
        // Check that it's integer
        try {
            int intId = Integer.parseInt(id);
            if (intId > 0) {
                return true;
            } else {
                System.out.println("> Please enter a positive integer");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("> Please enter an integer");
            return false;
        }
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean validateName(String name) {
        if (name.length() < 2) {
            System.out.println("> Please enter a name with 2 characters or more");
            return false;
        } else if (name.length() > 50) {
            System.out.println("> Please enter a name with 50 characters or less");
            return false;
        }
        return true;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean validateAbilityScore(String score) {
        try {
            int intScore = Integer.parseInt(score);
            if (intScore < 3) {
                System.out.println("> Please enter a score of 3 or more");
                return false;
            } else if (intScore > 20) {
                System.out.println("> Please enter a score of 20 or less");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("> Please enter an integer");
            return false;
        }
    }

    // Check for Duplication Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean checkDuplicateIds(String id, CharacterList list) {
        int intId = Integer.parseInt(id);
        int listId = 0;
        int listSize = list.getListSize();
        if (listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                listId = list.getCharacter(i).getId();
                if (listId == intId) {
                    System.out.println("> This ID already exists, please enter a new one");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static boolean checkDuplicateNames(String name, CharacterList list) {
        String listName = "";
        int listSize = list.getListSize();
        if (listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                listName = list.getCharacter(i).getName();
                if (listName.equals(name)) {
                    System.out.println("> This name already exists, please enter a new one");
                    return false;
                }
            }
        }
        return true;
    }

    // Custom Get Methods
    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */


    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static int getValidId(String id, CharacterList list) {
        while (true) {
            if (validateId(id)) {
                if (checkDuplicateIds(id, list)) {
                    break;
                } else {
                    id = inputAttribute("id");
                }
            } else {
                id = inputAttribute("id");
            }
        }
        return Integer.parseInt(id);
    }

    /**
     * --method:
     * --parameters:
     * --return:
     * --purpose:
     */
    public static String getValidName(String name, CharacterList list) {
        while (true) {
            if (validateName(name)) {
                if (checkDuplicateNames(name, list)) {
                    break;
                } else {
                    name = inputAttribute("name");
                }
            } else {
                name = inputAttribute("name");
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
    public static String getValidClassification(String classification) {
        boolean loop = true;
        while (loop) {
            switch (classification) {
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
                    System.out.println("> Invalid");
                    classification = inputAttribute("classification");
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
    public static String getValidRace(String race) {
        boolean loop = true;
        while (loop) {
            switch (race) {
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
                    System.out.println("> Invalid");
                    race = inputAttribute("race");
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
    public static int getValidAbilityScore(String ability, String score) {
        while (true) {
            if (validateAbilityScore(score)) {
                break;
            } else {
                score = inputAttribute(ability);
            }
        }
        return Integer.parseInt(score);
    }
}
