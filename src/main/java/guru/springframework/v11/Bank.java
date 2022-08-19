package guru.springframework.v11;

public class Bank {

    /**
     * First impl just hardcode it
     * First impl just hardcode it
     */
    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
/*        if (source instanceof Money) return (Money) source;
        Sum sum = (Sum) source;
        return sum.reduce(currency);*/
    }
}
