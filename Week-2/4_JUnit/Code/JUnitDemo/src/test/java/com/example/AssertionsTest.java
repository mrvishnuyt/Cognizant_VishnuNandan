package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());
        
     // Assert same (object reference)
        String a = "abc";
        String b = a;
        assertSame(a, b);

        // Assert not same
        String x = new String("abc");
        String y = new String("abc");
        assertNotSame(x, y);  // Different objects with same value

    }
}
