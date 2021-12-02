package guru.springframework;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    /**
     * Consolidate Tests
     */
    @Test
    void testEquality() {
        int amount = 5;
        assertEquals(Money.dollar(amount), Money.dollar(amount));

        // Now we are going to  make sure that 5 dollars does not equal 5 francs.
        assertNotEquals(Money.dollar(8), Money.dollar(amount));
        assertNotEquals(Money.dollar(amount), Money.franc(amount));

        assertEquals(Money.franc(amount), Money.franc(amount));
        assertNotEquals(Money.franc(8), Money.franc(amount));
    }

    /**
     * Consolidate Tests
     */
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        Money fiveF = Money.franc(5);
        assertEquals(Money.franc(10), fiveF.times(2));
        assertEquals(Money.franc(15), fiveF.times(3));
    }
    //----------------------------------------------
    //- End consolidated tests
    //----------------------------------------------

    @Test
    void testCurrency() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }























    @Test
    @Disabled("Old one")
    void testCurrency2() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    @Disabled("Replaced with testEquality generic method")
    void testEqualityDollar() {
        int amount = 5;
        assertEquals(Money.dollar(amount), Money.dollar(amount));

        // Now we are going to  make sure that 5 dollars does not equal 5 francs.
        assertNotEquals(Money.dollar(8), Money.dollar(amount));
        assertNotEquals(Money.dollar(amount), Money.franc(amount));
    }

    @Test
    @Disabled("Replaced with testMultiplication generic method")
    void testMultiplicationDollar() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    @Disabled("Replaced with testEquality generic method")
    void testEqualityFranc() {
        int amount = 5;
        assertEquals(Money.franc(amount), Money.franc(amount));
        assertNotEquals(Money.franc(8), Money.franc(amount));
    }

    @Test
    @Disabled("Replaced with testMultiplication generic method")
    void testMultiplicationFranc() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }


    //---------------------------------------------------------------------------
    // - Just to show the use of ParameterizedTest
    //---------------------------------------------------------------------------

/*    @ParameterizedTest(name = "{0}")
    @DisplayName("Should validate Dollar equality")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    @Disabled("Not used")
    void testEqualityDollarParams(int amount) {
        assertEquals(Money.dollar(amount), Money.dollar(amount));
    }*/

   /* @ParameterizedTest(name = "{0}")
    @DisplayName("Should create multiply dollar with different")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    //@CsvSource({"1, a", "1, b", "2, a", "2, b"})
    @Disabled("Need to update return from times method")
    void testMultiplicationDollar2(int multiplayer) {
        int[] amounts = {5, 7, 9, 12};
        for (int amount : amounts) {
            Dollar_NotUsed five = Money.dollar(amount);
            five.times(multiplayer);
            assertEquals(amount * multiplayer, five.getAmount());
        }

*//*        assertAll(() -> {
            assertEquals(10, five.getAmount());
        });*//*
    }*/

}
