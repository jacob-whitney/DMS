/**
 * Jacob Whitney
 * Software Development I
 * March 2, 2025
 * CharacterListTest.java
 * Description: Tests CRUD functionality of
 * Character Creator program
 */

// Imports
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CharacterListTest {

    // Create List object to be tested
    CharacterList list = new CharacterList();

    /**
     * method: setUp
     * parameters: none
     * return: void
     * purpose: setup required objects before each test
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        list.addCharacter(new Character(
                5678,
                "Sylwen Nightshade",
                "Ranger",
                "Elf",
                10,
                10,
                10
        ));
    }

    /**
     * method: testCreateCharacter
     * parameters: none
     * return: void
     * purpose: test that character object
     *          is created successfully
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Create Character Test")
    void testCreateCharacter() {
        // Setup
        int id = 1234;
        String name = "Thalric Ironfist";
        String classification = "Fighter";
        String race = "Dwarf";
        int str = 18;
        int dex = 16;
        int con = 12;
        list.addCharacter(new Character(id, name, classification, race, str, dex, con));

        String listContent = """
                5678 | Sylwen Nightshade | Ranger | Elf |  10  |  10  |  10
                1234 | Thalric Ironfist | Fighter | Dwarf |  18  |  16  |  12\n""";
        int listSize = 2;

        // Assertions
        assertNotNull(
                list.getCharacter(1),
                "Error: null character"
        );
        assertEquals(
                id,
                list.getCharacter(1).getId(),
                "Error: The character ID is incorrect"
        );
        assertEquals(
                name,
                list.getCharacter(1).getName(),
                "Error: The character Name is incorrect"
        );
        assertEquals(
                classification,
                list.getCharacter(1).getClassification(),
                "Error: The character Class is incorrect"
        );
        assertEquals(
                race,
                list.getCharacter(1).getRace(),
                "Error: The character Race is incorrect"
        );
        assertEquals(
                str,
                list.getCharacter(1).getStr(),
                "Error: The character Strength is incorrect"
        );
        assertEquals(
                dex,
                list.getCharacter(1).getDex(),
                "Error: The character Dexterity is incorrect"
        );
        assertEquals(
                con,
                list.getCharacter(1).getCon(),
                "Error: The character Constitution is incorrect"
        );
        assertEquals(
                listSize,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
        assertEquals(
                listContent,
                list.getCharacterList(),
                "Error: The character list is incorrect"
        );
    }

    /**
     * method: testDeleteCharacter
     * parameters: none
     * return: void
     * purpose: test that deleting character
     *          removes that object successfully
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Delete Character Test")
    void testDeleteCharacter() {
        // Setup
        list.deleteCharacter(String.valueOf("5678"));
        int index = 0;
        int count = 0;
        String listContent = "List is empty";

        // Assertions
        assertNull(
                list.getCharacter(index),
                "Error: character is not null"
        );
        assertEquals(
                count,
                list.getListSize(),
                "Error: list size is incorrect"
        );
        assertEquals(
                listContent,
                list.getCharacterList(),
                "Error: character list is incorrect"
        );
    }

    /**
     * method: testUpdateCharacter
     * parameters: none
     * return: void
     * purpose: test that updating attributes
     *          of a character object works successfully
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Update Character Test")
    void testUpdateCharacter() {
        // Setup
        int id = 9101;
        String name = "Seraphina Moonglow";
        String classification = "Warlock";
        String race = "Halfling";
        int str = 12;
        int dex = 13;
        int con = 14;

        list.updateCharacter("5678", "id", String.valueOf(id), list);
        list.updateCharacter("9101", "name", name, list);
        list.updateCharacter("9101", "class", classification, list);
        list.updateCharacter("9101", "race", race, list);
        list.updateCharacter("9101", "strength", String.valueOf(str), list);
        list.updateCharacter("9101", "dexterity", String.valueOf(dex), list);
        list.updateCharacter("9101", "constitution", String.valueOf(con), list);

        String listContent = id + " | " + name + " | " + classification + " | ";
        listContent = listContent + race + " |  " + str + "  |  " + dex + "  |  ";
        listContent = listContent + con + "\n";
        int index = 0;
        int count = 1;

        // Assertions
        assertNotNull(
                list.getCharacter(index),
                "Error: null character"
        );
        assertEquals(
                id,
                list.getCharacter(index).getId(),
                "Error: The character ID is incorrect"
        );
        assertEquals(
                name,
                list.getCharacter(index).getName(),
                "Error: The character Name is incorrect"
        );
        assertEquals(
                classification,
                list.getCharacter(index).getClassification(),
                "Error: The character Class is incorrect"
        );
        assertEquals(
                race,
                list.getCharacter(index).getRace(),
                "Error: The character Race is incorrect"
        );
        assertEquals(
                str,
                list.getCharacter(index).getStr(),
                "Error: The character Strength is incorrect"
        );
        assertEquals(
                dex,
                list.getCharacter(index).getDex(),
                "Error: The character Dexterity is incorrect"
        );
        assertEquals(
                con,
                list.getCharacter(index).getCon(),
                "Error: The character Constitution is incorrect"
        );
        assertEquals(
                count,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
        assertEquals(
                listContent,
                list.getCharacterList(),
                "Error: The character list is incorrect"
        );
    }

    /**
     * method: testRollAbilityScores
     * parameters: none
     * return: void
     * purpose: test that custom action of
     *          rolling randomg ability scores
     *          works successfully
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Custom Action Test")
    void testRollAbilityScores() {
        // Setup
        int index = 0;
        int count = 1;
        int id = 5678;
        String name = "Sylwen Nightshade";
        String classification = "Ranger";
        String race = "Elf";
        int str = Menu.getRandomAbilityScore();
        int dex = Menu.getRandomAbilityScore();
        int con = Menu.getRandomAbilityScore();

        list.updateCharacter(String.valueOf(id), "str", String.valueOf(str), list);
        list.updateCharacter(String.valueOf(id), "dex", String.valueOf(dex), list);
        list.updateCharacter(String.valueOf(id), "con", String.valueOf(con), list);

        String listContent = id + " | " + name + " | " + classification + " | ";
        listContent = listContent + race + " |  " + str + "  |  " + dex + "  |  ";
        listContent = listContent + con + "\n";


        // Assertions
        assertNotNull(
                list.getCharacter(index),
                "Error: null character"
        );
        assertEquals(
                id,
                list.getCharacter(index).getId(),
                "Error: The character ID is incorrect"
        );
        assertEquals(
                name,
                list.getCharacter(index).getName(),
                "Error: The character Name is incorrect"
        );
        assertEquals(
                classification,
                list.getCharacter(index).getClassification(),
                "Error: The character Class is incorrect"
        );
        assertEquals(
                race,
                list.getCharacter(index).getRace(),
                "Error: The character Race is incorrect"
        );
        assertEquals(
                str,
                list.getCharacter(index).getStr(),
                "Error: The character Strength is incorrect"
        );
        assertEquals(
                dex,
                list.getCharacter(index).getDex(),
                "Error: The character Dexterity is incorrect"
        );
        assertEquals(
                con,
                list.getCharacter(index).getCon(),
                "Error: The character Constitution is incorrect"
        );
        assertEquals(
                count,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
        assertEquals(
                listContent,
                list.getCharacterList(),
                "Error: The character list is incorrect"
        );
    }

    /**
     * method: testImportCharacter
     * parameters: none
     * return: void
     * purpose: test that reading a file
     *          and importing characters
     *          from it works successfully
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Import Characters Test")
    void testImportCharacter() {
        // Setup
        int count = 26;
        String filepath = "./resources/characters.txt";
        ArrayList<String> importChars = Menu.readFile(filepath);
        String listContent = """
                5678 | Sylwen Nightshade | Ranger | Elf |  10  |  10  |  10
                1001 | Thrain Ironfist | Barbarian | Dwarf |  18  |  14  |  16
                1002 | Eldrin Moonshadow | Rogue | Elf |  12  |  19  |  10
                1003 | Soren Blackflame | Warlock | Dragonborn |  15  |  13  |  9
                1004 | Mira Willowbrook | Ranger | Halfling |  14  |  17  |  12
                1005 | Orin Deepdelver | Fighter | Dwarf |  19  |  10  |  18
                1006 | Sylas Starfire | Wizard | Elf |  10  |  16  |  8
                1007 | Kaida Stormscale | Sorcerer | Dragonborn |  13  |  18  |  11
                1008 | Finn Copperkettle | Rogue | Gnome |  9  |  14  |  7
                1009 | Rowan Swiftblade | Fighter | Human |  17  |  12  |  14
                1010 | Zephyr Duskrun | Ranger | Elf |  11  |  19  |  13
                1011 | Baldric Stonehelm | Barbarian | Dwarf |  20  |  12  |  15
                1012 | Lirien Dawnwhisper | Wizard | Elf |  8  |  17  |  6
                1013 | Cassia Thornbrook | Warlock | Halfling |  14  |  9  |  10
                1014 | Drogan Ashenmaw | Sorcerer | Dragonborn |  16  |  15  |  12
                1015 | Jareth Windrider | Fighter | Human |  18  |  11  |  17
                1016 | Elowen Lightfoot | Rogue | Halfling |  7  |  16  |  8
                1017 | Magnus Ironbark | Warlock | Gnome |  13  |  14  |  10
                1018 | Tavian Stormborn | Ranger | Human |  15  |  18  |  14
                1019 | Brakka Flamebeard | Sorcerer | Dwarf |  17  |  12  |  15
                1020 | Nyx Shadowvale | Wizard | Gnome |  10  |  19  |  7
                1021 | Gideon Blackthorn | Barbarian | Human |  19  |  10  |  16
                1022 | Lyric Quickfoot | Rogue | Halfling |  8  |  17  |  9
                1023 | Elandor Silverleaf | Fighter | Elf |  12  |  13  |  11
                1024 | Thalia Ravenshade | Warlock | Human |  14  |  15  |  12
                1025 | Draven Nightbane | Ranger | Dragonborn |  16  |  14  |  13\n""";

        String charLine = "";
        for (int i = 0; i < importChars.size(); i++) {
            charLine = importChars.get(i);
            if (Menu.validateImportedString(charLine)) {
                list.addCharacter(Menu.parseAttributesFromString(charLine, list));
            }
        }

        // Assertions
        assertEquals(
                count,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
        assertEquals(
                listContent,
                list.getCharacterList(),
                "Error: The character list is incorrect"
        );
    }
}