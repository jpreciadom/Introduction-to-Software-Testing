import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {
    @Test
    public void isTriangle1() {
        assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void isTriangle2() {
        assertTrue(Demo.isTriangle(3.00001, 4, 7));
    }

    @Test
    public void isTriangle3() {
        assertTrue(Demo.isTriangle(7, 3.00001, 4));
    }

    @Test
    public void isTriangle4() {
        assertTrue(Demo.isTriangle(4, 7, 3.00001));
    }

    @Test
    public void isTriangle5() {
        assertTrue(Demo.isTriangle(3, 3, 3));
    }

    @Test
    public void isNotTriangle1() {
        assertFalse(Demo.isTriangle(3, 4, 7));
    }


    @Test
    public void isNotTriangle2() {
        assertFalse(Demo.isTriangle(7, 3, 4));
    }


    @Test
    public void isNotTriangle3() {
        assertFalse(Demo.isTriangle(4, 7, 3));
    }

    public static ByteArrayInputStream generateInputStream(String a, String b, String c) {
        StringBuilder builder = new StringBuilder();
        builder = builder.append(a).append("\n");
        builder = builder.append(b).append("\n");
        builder = builder.append(c).append("\n");
        return new ByteArrayInputStream(builder.toString().getBytes());
    }

    @Test
    public void mainIsTriangle1() {
        ByteArrayInputStream in = generateInputStream("3", "4", "6");
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutput = "";
        expectedOutput += "Enter side 1: \n";
        expectedOutput += "Enter side 2: \n";
        expectedOutput += "Enter side 3: \n";
        expectedOutput += "This is a triangle.\n";

        String[] args = {};
        Demo.main(args);

        assertEquals(out.toString(), expectedOutput);
    }

    @Test
    public void mainIsNotTriangle1() {
        ByteArrayInputStream in = generateInputStream("3", "4", "7");
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutput = "";
        expectedOutput += "Enter side 1: \n";
        expectedOutput += "Enter side 2: \n";
        expectedOutput += "Enter side 3: \n";
        expectedOutput += "This is not a triangle.\n";

        String[] args = {};
        Demo.main(args);

        assertEquals(out.toString(), expectedOutput);
    }
}
