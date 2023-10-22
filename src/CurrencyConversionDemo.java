interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency);
}

class SimpleCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double usdToEurRate = 0.85;
        double usdToGbpRate = 0.74;
        double result;

        if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            result = amount * usdToEurRate;
        } else if ("USD".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            result = amount * usdToGbpRate;
        } else if ("EUR".equals(fromCurrency) && "USD".equals(toCurrency)) {
            result = amount / usdToEurRate;
        } else if ("GBP".equals(fromCurrency) && "USD".equals(toCurrency)) {
            result = amount / usdToGbpRate;
        } else {
            result = amount;
        }

        return result;
    }
}

public class CurrencyConversionDemo {
    public static void main(String[] args) {
        CurrencyConverter converter = new SimpleCurrencyConverter();

        double amountInUSD = 100.0;
        String fromCurrency = "USD";
        String toCurrency = "EUR";

        double convertedAmount = converter.convert(amountInUSD, fromCurrency, toCurrency);
        System.out.println(amountInUSD + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
    }
}
