package guru.springframework.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. v2 - Remove mutation by checking times() for validity.
 * 2. v2 - Add real equality for Dollor object
 * 3. v2 - Added a testcase using new JUnit 5 features for Parameterized test with multiple values
 *
 * 4. v3 - Added privacy for Dollar object.
 *         amount should be private, and then we compare the whole Dollar object in testMutliplication method.
 *         Everything is maintained inside the Dollar object.
 */
public class MoneyTest {

    // 1. Remove mutation by checking times() for validity.
    // 2. Add real equality for Dollar object by introducing equals and hashcode methods
    @Test
    void testMutliplicationDollar() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(new Dollar(10), product);

        // Do re-factoring due to mutating side effect.
        // Should create a new Dollar object
        product = five.times(3);
        assertEquals(new Dollar(15), product);
    }

    @Test
    void testEquiltyDollar() {
        assertEquals(new Dollar(5), new Dollar(5));
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should validate Dollar equality")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    void testEqualityDollar(int amount) {
        assertEquals(new Dollar(amount), new Dollar(amount));
    }

    //----------------------------------------------------------
    // Duplicate tests for Frank
    //----------------------------------------------------------
    @Test
    void testMutliplicationFrank() {
        Franc five = new Franc(5);
        Franc product = five.times(2);
        assertEquals(new Franc(10), product);
        product = five.times(3);
        assertEquals(new Franc(15), product);
    }

    @Test
    void testEquiltyFranc() {
        assertEquals(new Franc(5), new Franc(5));
    }

}
