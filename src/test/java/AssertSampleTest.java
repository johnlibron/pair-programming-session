import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class AssertSampleTest {

    MoodAnalyser moodAnalyser;

    @Before
    public void setup() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    public void whenAssertingEquality_thenEqual() {
        System.out.println(moodAnalyser.analyseMethod("happy"));
        String expected = "Ramesh";
        String actual = "Ramesh";
        assertEquals("failure - strings are not equal", expected, actual);
    }

    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = {'J', 'u', 'n', 'i', 't'};
        char[] actual = "Junit".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenNullArrays_whenAssertingArraysEquality_thenEqual() {
        int[] expected = null;
        int[] actual = null;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenAssertingNull_thenTrue() {
        Object car = null;
        assertNull("The car should be null", car);
    }

    @Test
    public void whenAssertingNotSameObject_thenDifferent() {
        Object dog = new Object();
        Object cat = new Object();
        assertNotSame(dog, cat);
    }

    @Test
    public void whenAssertingConditions_thenVerified() {
        assertTrue("5 is greater than 4", 5 > 4);
        assertFalse("5 is not greater than 6", 5 > 6);
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("Java", "Kotlin", "Scala"), hasItems("Java", "Kotlin"));
    }
}
