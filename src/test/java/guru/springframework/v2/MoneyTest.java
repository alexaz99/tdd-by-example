package guru.springframework.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Remove mutation by checking times() for validity.
 * 2. Add real equality for Dollor object
 * 3. Added a testcase using new JUnit 5 features for Parameterized test with multiple values
 */
public class MoneyTest {

    // 1. Remove mutation by checking times() for validity.
    // 2. Add real equality for Dollar object by introducing equals and hashcode methods
    @Test
    void testMutliplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);

        // Do re-factoring due to mutating side effect.
        // Should create a new Dollar object
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    void testEquality() {
        assertEquals(new Dollar(5), new Dollar(5));
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should validate Dollar equality")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    void testEquality(int amount) {
        assertEquals(new Dollar(amount), new Dollar(amount));
    }

}
