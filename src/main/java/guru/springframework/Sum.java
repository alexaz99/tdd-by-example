package guru.springframework;

public class Sum implements Expression {
    /* We do action on Money */
    Money augmend;
    Money addmend;

    public Sum(Money augment, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }
}
