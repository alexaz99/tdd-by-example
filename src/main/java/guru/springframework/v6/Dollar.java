package guru.springframework.v6;

/**
 * APIs
 *  times
 *  equals
 *  hashCode
 *
 *  move constructor to Money class
 */
public class Dollar extends Money {

    // externalize currency and move to a parent class
    //private String currency;

    // move constructor to Money class
    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

    // move to ancestor
/*    @Override
    public String currency() {
        return currency;
    }*/

}
