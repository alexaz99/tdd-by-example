package guru.springframework.v7;

import java.util.Objects;

public /*abstract*/ class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    //public abstract Money times(int multiplier);

/*    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }*/

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    //public abstract String currency();

    protected String currency() {
        return currency;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false; //|| getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
