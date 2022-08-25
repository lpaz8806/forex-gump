package se.jensensthlm.forexgump;

public class ExchangeCalculator {
    private String referenceCurrency = "SEK";
    private ExchangeProvider exchangeProvider;

    public ExchangeCalculator(ExchangeProvider exchangeProvider) {
        this.exchangeProvider = exchangeProvider;
    }

    public String getReferenceCurrency() { return referenceCurrency; }

    /**
     * Computes how many units of reference currency you have to pay in order to
     * buy amountToPay units of targetCurrency
     * @param targetCurrency The currency you want to buy
     * @param amount The amountToPay of units you want to buy
     * @return The amountToPay of units of reference currency you have to pay
     */
    public double calculateBuy(String targetCurrency, double amount) {
        checkTargetCurrency(targetCurrency, "Can't buy the same currency");
        var rate = getExchangeRate(referenceCurrency, targetCurrency);
        return amount * rate;
    }

    public double calculateSell(String targetCurrency, double amount) {
        checkTargetCurrency(targetCurrency, "Can't sell the same currency");
        var rate = getExchangeRate(referenceCurrency, targetCurrency);
        return amount / rate;
    }

    private void checkTargetCurrency(String targetCurrency, String message) {
        if (referenceCurrency.equals(targetCurrency)) {
            throw new IllegalArgumentException(message);
        }
    }

    private double getExchangeRate(String sourceCurrency, String targetCurrency) {
        var details = exchangeProvider.get(sourceCurrency, targetCurrency);
        if (details == null) {
            throw new IllegalArgumentException("Currency pair %s-%s does not exist".formatted(sourceCurrency, targetCurrency));
        }
        return details.rate();
    }
}
