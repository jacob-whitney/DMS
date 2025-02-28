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
     * method: test
     * parameters: none
     * return: void
     * purpose:
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
     * method: test
     * parameters: none
     * return: void
     * purpose:
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Create Character Test")
    void testCreateCharacter() {
        // Setup
        list.addCharacter(new Character(
                1234,
                "Thalric Ironfist",
                "Fighter",
                "Dwarf",
                18,
                16,
                12
        ));

        // Assertions
        assertNotNull(list.getCharacter(1), "Error: null character");
        assertEquals(
                1234,
                list.getCharacter(1).getId(),
                "Error: The character ID is incorrect"
        );
        assertEquals(
                "Thalric Ironfist",
                list.getCharacter(1).getName(),
                "Error: The character Name is incorrect"
        );
        assertEquals(
                "Fighter",
                list.getCharacter(1).getClassification(),
                "Error: The character Class is incorrect"
        );
        assertEquals(
                "Dwarf",
                list.getCharacter(1).getRace(),
                "Error: The character Race is incorrect"
        );
        assertEquals(
                18,
                list.getCharacter(1).getStr(),
                "Error: The character Strength is incorrect"
        );
        assertEquals(
                16,
                list.getCharacter(1).getDex(),
                "Error: The character Dexterity is incorrect"
        );
        assertEquals(
                12,
                list.getCharacter(1).getCon(),
                "Error: The character Constitution is incorrect"
        );
        assertEquals(
                2,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
    }

    /**
     * method: test
     * parameters: none
     * return: void
     * purpose:
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Delete Character Test")
    void testDeleteCharacter() {
    }

    /**
     * method: test
     * parameters: none
     * return: void
     * purpose:
     */
    @org.junit.jupiter.api.Test
    void updateCharacter() {
    }

    /**
     * method: test
     * parameters: none
     * return: void
     * purpose:
     */
    @org.junit.jupiter.api.Test
    @DisplayName("Import Characters Test")
    void testImportCharacter() {
        // Setup
        ArrayList<String> importChars = Menu.readFile("./resources/characters.txt");
        String fileContent = """
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
                26,
                list.getListSize(),
                "Error: The list size is incorrect"
        );
        assertEquals(
                fileContent,
                list.getCharacterList(),
                "Error: The character list is incorrect"
        );
    }
}