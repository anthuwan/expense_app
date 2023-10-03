package expense.calculator.app.generator;

import expense.calculator.app.domain.Expense;
import expense.calculator.app.domain.Expenses;
import expense.calculator.app.service.InputSource;
import expense.calculator.app.validator.GenericValidator;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class XMLSource implements InputSource {

    @Qualifier("validators")
    @Autowired
    private Map<String, GenericValidator> validators;

    @Override
    public List<Expense> getExpense(Properties prop) {
        String xmlInput = prop.getProperty("xmlInput");
        GenericValidator xmlValidator = validators.get("xml");

        if (Objects.isNull(xmlValidator)) {
            throw new RuntimeException("XmlValidator not found");
        }

        if (xmlValidator.validate(xmlInput)) {
            return parseXml(xmlInput);
        } else {
            return null;
        }

    }


    private List<Expense> parseXml(String xmlInput) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Expenses.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlInput);
            Expenses expenses = (Expenses) unmarshaller.unmarshal(reader);

            return expenses.getExpenseList();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
