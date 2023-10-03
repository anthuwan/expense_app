package expense.calculator.app.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public
class Expense {
    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "currencyType")
    private String currencyType;

    @XmlElement(name = "amount")
    private double amount;

    @XmlElement(name = "date")
    private String date;

}