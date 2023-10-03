package expense.calculator.app.generator;

public class CurrencyValueProvider {

    public double getCurrencyValue(String currency, String targetCurrencyType, String dateString,
        String targetDate) {

        if (currency.trim().equalsIgnoreCase("USD")
            || currency.trim().equalsIgnoreCase("EUR") && targetCurrencyType.trim().equals("INR")
            && dateString.equalsIgnoreCase(targetDate)) {
            return 82.0;
        } else {

            return 1.0;
        }
    }


}
