
package expense.calculator.app.validator;

import expense.calculator.app.exception.ValidationFailureException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class XmlValidator implements GenericValidator {


    @Override
    public boolean validate(final Object data) {
        if (!(data instanceof String)) {
            throw new ValidationFailureException(HttpStatus.BAD_REQUEST.name(), "ERROR_001",
                String.valueOf(HttpStatus.BAD_REQUEST.value()), "The XML provided is invalid",
                null);
        }

        return xmlValidator((String) data);
    }

    private boolean xmlValidator(final String xmlInput) {
        return validateFormat(xmlInput) && isXmlValid(xmlInput);
    }

    private boolean validateFormat(final String xmlInput) {

        return true;
    }

    private boolean isXmlValid(final String data) {
        if (Objects.isNull(data)) {
            throw new ValidationFailureException(HttpStatus.BAD_REQUEST.name(), "ERROR_001",
                String.valueOf(HttpStatus.BAD_REQUEST.value()), "The XML provided is invalid",
                null);
        }

        return true;
    }
}
