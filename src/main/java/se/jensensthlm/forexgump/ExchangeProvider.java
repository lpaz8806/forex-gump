package se.jensensthlm.forexgump;

public interface ExchangeProvider {
    ExchangeDetails get(String sourceCurrency, String targetCurrency);
}
