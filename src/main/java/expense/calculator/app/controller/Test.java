package expense.calculator.app.controller;

import expense.calculator.app.common.AppConstants;
import expense.calculator.app.generator.CurrencyValueProvider;
import expense.calculator.app.generator.ExpenseCalculator;
import expense.calculator.app.generator.XMLSource;
import expense.calculator.app.service.InputSource;
import expense.calculator.app.utils.FileUtility;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {

    public static void main(String[] args) throws IOException {
        String payloadAll = FileUtility.getFileContent(AppConstants.XML_JSOM);

        InputSource xmlSource = new XMLSource();
        CurrencyValueProvider currencyValueProvider = new CurrencyValueProvider();

        ExpenseCalculator expenseCalculator = new ExpenseCalculator(xmlSource,
            currencyValueProvider);

        String targetCurrencyType = "INR";
        LocalDate targetDate = LocalDate.of(2023, Month.JULY, 15);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String formattedDate = targetDate.format(formatter);

        double totalExpense = expenseCalculator.calculateExpense(payloadAll.replace("\n", ""),
            targetCurrencyType, formattedDate);

        System.out.println("Total Expense in INR: " + totalExpense);
    }
}
