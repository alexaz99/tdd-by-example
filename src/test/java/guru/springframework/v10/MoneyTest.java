package guru.springframework.v10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Idea is to do incremental re-factoring.
 *
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
 * 7. v5 - Goal is to refactor them out of existence.
 *        Remove product variable and make the test cleaner.
 *
 * 8. v5 - Create a factory method on Money to return Dollars and Francs.
 *      We will reduce direct references to subclasses.
 * 9. v6 - Add currency support.
 *    The final goal is to get rid of 2 subclasses
 * 10. v7 - Move times to Money class
 * 11. v8 - Removed completely Dollar and Frank classes and everything is in Money class.
 * 12. v9.- Do addition of different currencies.
 *          Add a new test case => void testSimpleAddition().
 *          Add basic classes and interfaces and make test green by hardcoding
 *
 * 13. v10. Make it working
 *
 *
 */
public class MoneyTest {

    // 1. Remove mutation by checking times() for validity.
    // 2. Add real equality for Dollar object by introducing equals and hashcode methods
    @Test
    void testMutliplicationDollar() {
        Money five = Money.dollar(5);
        //Dollar five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(8));

        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));

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
        Money five = Money.franc(5);
        //Franc five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    void testEquiltyFranc() {
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));
        assertNotEquals(Money.franc(8), Money.dollar(8));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    /**
     * New test case
     */
    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
