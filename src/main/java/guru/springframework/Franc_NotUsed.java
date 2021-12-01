package guru.springframework;

/**
 * Class to test.
 */
public class Franc_NotUsed extends Money {

    public Franc_NotUsed(int amount, String currency) {
        super(amount, currency);
    }

    /**
     * Create a new Dollar object.
     * So the object is not mutable.
     */
/*    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }*/
}
