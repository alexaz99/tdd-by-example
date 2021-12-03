package guru.springframework;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && this.currency == money.currency;
    }

    /**
     * Should pass a Bank to get a currency pair rate
     * This is where conversion happens
     */
    @Override
    public Money reduce(Bank bank, String to) {
        // first draft
/*        return this;*/

        // second draft
        // do rate conversion
/*        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        return new Money(amount / rate, to);*/

        // the latest. Get rate from a bank
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Expression addend) {
        //return new Money(amount + addend.amount, currency);
        return new Sum(this, addend);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}

