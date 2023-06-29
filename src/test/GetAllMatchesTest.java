package test;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static utils.StringUtils.findAllMatches;

public class GetAllMatchesTest {

    @BeforeAll
    static void setup(){

    }

    @AfterAll
    static void teardown(){
    }

    @Test
    @DisplayName("s = null")
    void UTCID01(){
        Assertions.assertThrows(Exception.class,() -> findAllMatches(null,"abc"));
    }

    @Test
    @DisplayName("regex = null")
    void UTCID02(){
        Assertions.assertThrows(Exception.class,() -> findAllMatches("abc",null));
    }

    @Test
    @DisplayName("Read matches")
    void UTCID03(){
        String[] array = {"a","a"};
        Assertions.assertArrayEquals(array,findAllMatches("abccab","a"));
    }

    @Test
    @DisplayName("Blank Regex")
    void UTCID04(){
        Assertions.assertThrows(Exception.class,() -> findAllMatches("abccab",""));
    }

    @Test
    @DisplayName("Invalid Regex")
    void UTCID05(){
        Assertions.assertThrows(Exception.class,() -> findAllMatches("abccab","\\"));
    }

    @Test
    @DisplayName("No Matches")
    void UTCID06(){
        Assertions.assertEquals(0, findAllMatches("abccab", "d").length);
    }

    @Test
    @DisplayName("Matches 1 or more case")
    void UTCID07(){
        String[] array = {"cc"};
        Assertions.assertArrayEquals(array,findAllMatches("abccab","c+"));
    }

    @Test
    @DisplayName("Start of String")
    void UTCID08(){
        String[] array = {"ab"};
        Assertions.assertArrayEquals(array,findAllMatches("abccab","^ab"));
    }

    @Test
    @DisplayName("End of String")
    void UTCID09(){
        String[] array = {"ab"};
        Assertions.assertArrayEquals(array,findAllMatches("abccab","ab$"));
    }

    @Test
    @DisplayName("Weird characters for Regex")
    void UTCID10(){
        String[] array = {"日本国"};
        Assertions.assertArrayEquals(array,findAllMatches("日本国","日本国"));
    }

    @Test
    @DisplayName("Weird characters with \\w")
    void UTCID11(){
        Assertions.assertEquals(0,findAllMatches("日本国","\\w").length);
    }
}
