package guru.springframework.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    /**
     * 1. Start just writing a test case without even java classes.
     * 2. Then add java classes
     * 3. Next step check TODO list a do re-factory and add logic
     */
    @Test
    void testMutliplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}
