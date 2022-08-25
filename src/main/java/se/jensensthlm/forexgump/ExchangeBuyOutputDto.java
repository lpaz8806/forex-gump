package se.jensensthlm.forexgump;

public record ExchangeBuyOutputDto(String currency, double amountToPay) {
    @Override
    public String toString() {
        return "%s %f".formatted(currency, amountToPay);
    }
}
