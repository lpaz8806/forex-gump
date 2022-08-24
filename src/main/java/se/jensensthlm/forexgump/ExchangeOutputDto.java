package se.jensensthlm.forexgump;

public record ExchangeOutputDto(String currency, double amount) {
    @Override
    public String toString() {
        return "%s %f".formatted(currency, amount);
    }
}
