package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestClassTemplate {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    private static String test;

    @BeforeAll
    static void setup(){
        test = "hello";
        //For System.out Testing
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    static void teardown(){
        //For System.out Testing
//        System.setOut(originalOut);
//        System.setErr(originalErr);
    }

    @Test
    void TestCase_01(){
        Assertions.assertEquals(test,"hello");
    }


}
