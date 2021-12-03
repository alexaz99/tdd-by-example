package guru.springframework;

public class Sum implements Expression {
    /* We do action on Money */
    Money augmend;
    Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.amount + addmend.amount;
        return new Money(amount, to);
    }
}
