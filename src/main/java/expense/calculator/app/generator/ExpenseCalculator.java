package expense.calculator.app.generator;

import expense.calculator.app.domain.Expense;
import expense.calculator.app.service.InputSource;
import java.util.List;
import java.util.Properties;

public class ExpenseCalculator {

    private InputSource inputSource;
    private CurrencyValueProvider currencyValueProvider;

    public ExpenseCalculator(InputSource inputSource, CurrencyValueProvider currencyValueProvider) {
        this.inputSource = inputSource;
        this.currencyValueProvider = currencyValueProvider;
    }

    public double calculateExpense(String xmlInput, String targetCurrencyType, String targetDate) {
        Properties properties = new Properties();
        properties.setProperty("targetCurrencyType", targetCurrencyType);
        properties.setProperty("xmlInput", xmlInput);

        List<Expense> expenses = inputSource.getExpense(properties);
        return expenses.stream().mapToDouble(expense -> {
            double exchangeRate = currencyValueProvider.getCurrencyValue(expense.getCurrencyType(),
                targetCurrencyType, expense.getDate().trim(), targetDate);
            return expense.getAmount() * exchangeRate;
        }).sum();

    }


}

