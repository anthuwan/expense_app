package expense.calculator.app.config;

import expense.calculator.app.validator.GenericValidator;
import expense.calculator.app.validator.XmlValidator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {


    @Bean(name = "validators")
    public Map<String, GenericValidator> validators() {
        Map<String, GenericValidator> validators = new HashMap<>();
        validators.put("", new XmlValidator());
        return validators;
    }
}
