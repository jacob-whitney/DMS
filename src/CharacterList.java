/**
 * Jacob Whitney
 * Software Development I
 * February 23, 2025
 * CharacterList.java
 * Description: manages list of Character objects
 * to be viewed or edited.
 */

// Imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterList {
    // Attributes
    private List<Character> characters;
    private static final Scanner sc = new Scanner(System.in);

    // Constructor
    public CharacterList(List<Character> characters) {
        this.characters = new ArrayList<>(characters);
    }

    public CharacterList() {
        this.characters = new ArrayList<>();
    }

    // Custom Methods
    /**
     * method: getCharacter
     * parameters: index
     * return: Character
     * purpose: Gets Character object
     *            by index number
     */
    public Character getCharacter(int index) {
        if (!characters.isEmpty() && index >= 0 && index < characters.size()) {
            return characters.get(index);
        } else {
            System.out.println("This list is empty");
            return null;
        }
    }

    /**
     * method: getCharacterList
     * parameters: none
     * return: String
     * purpose: Prints existing list of Characters
     */
    public String getCharacterList() {
        if (!characters.isEmpty()) {
            String charList = "";
            for (int i = 0; i < characters.size(); i++) {
                Character c = characters.get(i);
                charList = charList + c.getId()             + " | ";
                charList = charList + c.getName()           + " | ";
                charList = charList + c.getClassification() + " | ";
                charList = charList + c.getRace() + " |  ";
                charList = charList + c.getStr()            + "  |  ";
                charList = charList + c.getDex()            + "  |  ";
                charList = charList + c.getCon()            + "\n";
            }
            return charList;
        } else {
            return "List is empty";
        }
    }

    /**
     * method: getListSize
     * parameters: none
     * return: int
     * purpose: Gets number of records
     *            in Character list
     */
    public int getListSize() {
        return characters.size();
    }

    /**
     * method: addCharacter
     * parameters: character
     * return: List<Character>
     * purpose: Adds Character to list
     */
    public List<Character> addCharacter( Character character) {
        characters.add(character);
        return characters;
    }

    /**
     * method: deleteCharacter
     * parameters: id
     * return: List<Character>
     * purpose: Deletes Character from list
     */
    public List<Character> deleteCharacter(String id) {
        while (true) {
            if (Menu.validateId(id)) {
                int deleteId = Integer.parseInt(id);
                boolean removed = characters.removeIf(character -> character.getId() == deleteId);
                if (removed) {
                    System.out.println("Character deleted and list updated");
                    break;
                } else {
                    System.out.println("> ID not found, try again");
                    id = Menu.inputAttribute("id");
                }
            } else {
                id = Menu.inputAttribute("id");
            }
        }

        return characters;
    }

    /**
     * method: updateCharacter
     * parameters: id, attribute, value, list
     * return: List<Character>
     * purpose: Updates one attribute for
     *            any Character in list
     */
    public List<Character> updateCharacter(String id, String attribute, String value, CharacterList list) {
        for (Character c : characters) {
            if (c.getId() == Integer.parseInt(id)) {
                boolean loop = true;
                while (loop) {
                    switch (attribute) {
                        case "id", "ID":
                            int updateId = Menu.getValidId(value, list);
                            c.setId(updateId);
                            System.out.println("Character " + id + "'s ID updated to " + updateId);
                            loop = false;
                            break;
                        case "name", "Name":
                            String updateName = Menu.getValidName(value, list);
                            c.setName(updateName);
                            System.out.println("Character " + id + "'s Name updated to " + updateName);
                            loop = false;
                            break;
                        case "class", "Class":
                            String updateClassification = Menu.getValidClassification(value);
                            c.setClassification(updateClassification);
                            System.out.println("Character " + id + "'s Class updated to " + updateClassification);
                            loop = false;
                            break;
                        case "race", "Race":
                            String updateRace = Menu.getValidRace(value);
                            c.setRace(updateRace);
                            System.out.println("Character " + id + "'s Race updated to " + updateRace);
                            loop = false;
                            break;
                        case "str", "Str", "strength", "Strength":
                            int updateStr = Menu.getValidAbilityScore("str", value);
                            c.setStr(updateStr);
                            System.out.println("Character " + id + "'s Strength updated to " + updateStr);
                            loop = false;
                            break;
                        case "dex", "Dex", "dexterity", "Dexterity":
                            int updateDex = Menu.getValidAbilityScore("dex", value);
                            c.setDex(updateDex);
                            System.out.println("Character " + id + "'s Dexterity updated to " + updateDex);
                            loop = false;
                            break;
                        case "con", "Con", "constitution", "Constitution":
                            int updateCon = Menu.getValidAbilityScore("con", value);
                            c.setCon(updateCon);
                            System.out.println("Character " + id + "'s Constitution updated to " + updateCon);
                            loop = false;
                            break;
                        default:
                            System.out.println("> The attribute you entered is invalid, please try again");
                            System.out.println(Menu.printAttributes());
                            System.out.print("Attribute: ");
                            attribute = sc.nextLine();
                    }
                }

            }
        }
        return characters;
    }

}
