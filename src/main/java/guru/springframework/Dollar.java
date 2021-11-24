package guru.springframework;

/**
 * Class to test.
 */
public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void times(int multiplier) {
        amount *= multiplier;
    }
}
