package test;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DateTimeException;
import static utils.DateUtils.getDayOfWeek;

public class DayOfWeekTest {
    private final int[] monthsWith30Days = {4,6,9,11};
    private final int[] monthsWith31Days = {1,3,5,7,8,10,12};

    @BeforeAll
    static void setup(){
    }
    @AfterAll
    static void teardown() {
    }
    @Test
    @DisplayName("Negative Day")
    void UTCID01(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(-5,1,2000));
    }

    @Test
    @DisplayName("Zero Day")
    void UTCID02(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(0,1,2000));
    }

    @Test
    @DisplayName("Day 32")
    void UTCID03(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(32,1,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 2")
    void UTCID04_1(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(31,2,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 4")
    void UTCID04_2(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(31,4,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 6")
    void UTCID04_3(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(31,6,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 9")
    void UTCID04_4(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(31,9,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 11")
    void UTCID04_5(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(31,11,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 1, 2000 -> Monday")
    void UTCID05_1(){
        Assertions.assertEquals("Monday",getDayOfWeek(31,1,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 3, 2000 -> Friday")
    void UTCID05_2(){
        Assertions.assertEquals("Friday",getDayOfWeek(31,3,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 5, 2000 -> Wednesday")
    void UTCID05_3(){
        Assertions.assertEquals("Wednesday",getDayOfWeek(31,5,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 7, 2000 -> Monday")
    void UTCID05_4(){
        Assertions.assertEquals("Monday",getDayOfWeek(31,7,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 8, 2000 -> Thursday")
    void UTCID05_5(){
        Assertions.assertEquals("Thursday",getDayOfWeek(31,8,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 10, 2000 -> Tuesday")
    void UTCID05_6(){
        Assertions.assertEquals("Tuesday",getDayOfWeek(31,10,2000));
    }

    @Test
    @DisplayName("Day 31 in Month 8, 2000 -> Sunday")
    void UTCID05_7(){
        Assertions.assertEquals("Sunday",getDayOfWeek(31,12,2000));
    }

    @Test
    @DisplayName("Day 29 in Month 2, not Leap Year")
    void UTCID06(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(29,2,2002));
    }

    @Test
    @DisplayName("Day 29 in Month 2, 2000 (Leap Year) -> Tuesday")
    void UTCID07(){
        Assertions.assertEquals("Tuesday",getDayOfWeek(29,2,2000));
    }

    @Test
    @DisplayName("Negative Month")
    void UTCID08(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(1,-1,2000));
    }

    @Test
    @DisplayName("Month Zero")
    void UTCID09(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(1,0,2000));
    }

    @Test
    @DisplayName("Month 13")
    void UTCID10(){
        Assertions.assertThrows(DateTimeException.class,
                () -> getDayOfWeek(1,13,2000));
    }

    @Test
    @DisplayName("Year 0: 1 / 1 / 0 -> Saturday")
    void UTCID11(){
        Assertions.assertEquals("Saturday",getDayOfWeek(1,1,0));
    }

    @Test
    @DisplayName("Negative Year: 1 / 1 / -4 -> Monday")
    void UTCID19(){
        Assertions.assertEquals("Monday",getDayOfWeek(1,1,-4));
    }

    @Test
    @DisplayName("Negative Leap Year: 29 / 2 / -4 -> Thursday")
    void UTCID20(){
        Assertions.assertEquals("Thursday",getDayOfWeek(29,2,-4));
    }

    @Test
    @DisplayName("29 / 2 / 2100 -> DateTimeException")
    void UTCID21(){
        Assertions.assertThrows(DateTimeException.class,() -> getDayOfWeek(29,2,2100));
    }
}
