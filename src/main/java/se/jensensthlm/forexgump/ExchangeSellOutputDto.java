package se.jensensthlm.forexgump;

public record ExchangeSellOutputDto(String currency, double amountGet) {
    @Override
    public String toString() {
        return "%s %f".formatted(currency, amountGet);
    }
}
