package expense.calculator.app.domain;

import javax.xml.bind.annotation.*;
import java.util.List;
import lombok.Data;

@XmlRootElement(name = "expenses")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Expenses {

    @XmlElement(name = "expense")
    private List<Expense> expenseList;

}


