package expense.calculator.app.service;

import expense.calculator.app.domain.Expense;
import java.util.List;
import java.util.Properties;

public interface InputSource {
    List<Expense> getExpense(Properties prop);
}
