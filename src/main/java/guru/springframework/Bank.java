package guru.springframework;

import java.util.HashMap;
import java.util.Objects;

public class Bank {

    /** Keep a hashmap of currency pairs and rates */
    private HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        // if currency pair are equals, return 1!
        if (from.equals(to)) {
            return 1;
        }
        return rateMap.get(new Pair(from, to));

        //return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
