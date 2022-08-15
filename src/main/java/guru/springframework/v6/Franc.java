package guru.springframework.v6;

/**
 * move constructor to Money class
 */
public class Franc extends Money {

    //private String currency;

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

/*    @Override
    public String currency() {
        return currency;
    }*/

}
