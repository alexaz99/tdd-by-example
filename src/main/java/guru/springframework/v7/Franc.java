package guru.springframework.v7;

/**
 * move constructor to Money class
 */
public class Franc extends Money {

    //private String currency;

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    // move to Money
/*    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);

    }*/

/*    @Override
    public String currency() {
        return currency;
    }*/

}
