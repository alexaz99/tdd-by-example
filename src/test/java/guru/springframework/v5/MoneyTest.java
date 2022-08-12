package guru.springframework.v5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 1. v2 - Remove mutation by checking times() for validity.
 * 2. v2 - Add real equality for Dollor object
 * 3. v2 - Added a testcase using new JUnit 5 features for Parameterized test with multiple values
 *
 * 4. v3 - Added privacy for Dollar object.
 *         amount should be private, and then we compare the whole Dollar object in testMutliplication method.
 *         Everything is maintained inside the Dollar object.
 * 5. v4 - Refactory by introducing ancestor Money class and move common functionality there.
 *
 * 6. v4 - Now we are going to  make sure that 5 dollars does not equals 5 francs.
 * 7. v5. Goal is to refactor them out of existence.
 *        Remove product variable and make the test cleaner.
 *
 * 8. v5. Create a factory method on Money to return Dollars and Francs.
 * 9. We will reduce direct references to subclasses.
 */
public class MoneyTest {

    // 1. Remove mutation by checking times() for validity.
    // 2. Add real equality for Dollar object by introducing equals and hashcode methods
    @Test
    void testMutliplicationDollar() {
        Dollar five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(8));
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should validate Dollar equality")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    void testEqualityDollar(int amount) {
        assertEquals(Money.dollar(amount), Money.dollar(amount));
    }

    //----------------------------------------------------------
    // Duplicate tests for Frank
    //----------------------------------------------------------
    @Test
    void testMutliplicationFrank() {
        Franc five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    void testEquiltyFranc() {
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));
        assertNotEquals(Money.franc(8), Money.dollar(8));
    }

}
