

package expense.calculator.app.exception;

import expense.calculator.app.domain.ErrorDetails;
import expense.calculator.app.domain.ErrorResponse;
import java.util.Collections;
import java.util.UUID;
import javax.validation.ValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class ValidationFailureException extends ValidationException {

    private final String code;

    private final String statusCode;

    private final String statusDescription;

    private final UUID xrequestId;

    public ValidationFailureException(
        final String msg, final String code, final String statusCode,
        final String statusDescription, final UUID xrequestId) {
        super(msg);
        this.code = code;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.xrequestId = xrequestId;
    }

    public ErrorResponse toErrorResponse() {
        ErrorResponse error = new ErrorResponse();
        return error.description(statusDescription)
            .code(code)
            .statusCode(Integer.parseInt(statusCode))
            .message(getMessage())
            .xrequestId(this.xrequestId)
            .errors(Collections.singletonList(new ErrorDetails(code, statusDescription)));
    }
}
