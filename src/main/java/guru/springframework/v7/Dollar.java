package guru.springframework.v7;

/**
 * APIs
 *  times
 *  equals
 *  hashCode
 *
 *  move constructor to Money class
 *  move times to Money class
 */
public class Dollar extends Money {

    // externalize currency and move to a parent class
    //private String currency;

    // move constructor to Money class
    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    // move to Money
/*    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }*/

    // move to ancestor
/*    @Override
    public String currency() {
        return currency;
    }*/

}
