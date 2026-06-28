import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Check if expected and actual values are equal
        assertEquals(5, 2 + 3);

        // Check if the condition is true
        assertTrue(5 > 3);

        // Check if the condition is false
        assertFalse(5 < 3);

        // Check if the object is null
        assertNull(null);

        // Check if the object is not null
        assertNotNull(new Object());
    }
}