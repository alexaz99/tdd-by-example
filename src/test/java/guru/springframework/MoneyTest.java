package guru.springframework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.getAmount());
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should create multiply dollar with different     void testMultiplication2() {\n")
    @ValueSource(ints = {2, 3, 4, 5, 8, 14})
    void testMultiplication2(int multiplayer) {
        int[] amounts = {5, 7, 9, 12};
        for (int i = 0; i < amounts.length; i++) {
            Dollar five = new Dollar(amounts[i]);
            five.times(multiplayer);
            assertEquals(amounts[i] * multiplayer, five.getAmount());
        }

/*        assertAll(() -> {
            assertEquals(10, five.getAmount());
        });*/
    }

}
