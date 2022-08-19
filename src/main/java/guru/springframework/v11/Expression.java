package guru.springframework.v11;

public interface Expression {
    Money reduce(Bank bank, String to);
}
