package guru.springframework;

/**
 * Class to test.
 */
public class Dollar_First {
    private int amount;

    public Dollar_First(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void times(int multiplier) {
        amount *= multiplier;
    }
}
