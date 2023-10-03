
package expense.calculator.app.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import expense.calculator.app.common.ExpenseValidationStatus;
import expense.calculator.app.domain.ErrorResponse;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.thymeleaf.util.StringUtils;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String ERROR = "Error!";

    public ErrorResponse buildErrorGenericResponse(
        final String localizedMessage, final HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDescription(ExpenseValidationStatus.fromValue(status.value()));
        errorResponse.setCode(ExpenseValidationStatus.getCode(status.value()));
        errorResponse.setMessage(localizedMessage);
        if (status == HttpStatus.BAD_REQUEST) {
            errorResponse.setStatusCode(ExpenseValidationStatus.BADREQUEST.getStatusCode());
        } else {
            errorResponse.setStatusCode(
                ExpenseValidationStatus.INTERNALSERVERERROR.getStatusCode());
        }
        return errorResponse;
    }

    public ErrorResponse buildErrorResponse(ExpenseException ex) {
        ErrorResponse errorResponse = new ErrorResponse();

        if (!Objects.isNull(ex.getResponse())) {
            errorResponse.setStatusCode(ex.getStatusCode());
            errorResponse.setDescription(ex.getResponse().getDescription());
            errorResponse.setCode(ex.getResponse().getCode());
            errorResponse.setMessage(ex.getResponse().getMessage());
        } else {
            errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorResponse.setDescription(ex.getDescription());
            errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
            errorResponse.setMessage(ex.getMessage());
        }
        return errorResponse;
    }

    @ExceptionHandler(value = ExpenseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(ExpenseException ex) {
        log.error(ERROR, ex);
        log.info("Inside handleBaseException {}", ex.getMessage());
        ErrorResponse errorResponse = buildErrorResponse(ex);
        log.info("Inside handleBaseException {}", ex.getMessage());
        return new ResponseEntity<>(
            errorResponse,
            errorResponse.getStatusCode() != 0
                ? HttpStatus.valueOf(errorResponse.getStatusCode())
                : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ValidationFailureException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(final ValidationFailureException ex) {
        log.error(ERROR, ex);
        log.info("Inside handleBaseException {}", ex.getMessage());
        ErrorResponse errorResponse = ex.toErrorResponse();
        log.info("Inside handleBaseException {}", ex.getMessage());
        return new ResponseEntity<>(
            errorResponse,
            errorResponse.getStatusCode() != 0
                ? HttpStatus.valueOf(errorResponse.getStatusCode())
                : HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleServletRequest(ServletRequestBindingException ex) {
        log.error("inside  handleServletRequest", ex);
        ErrorResponse errorResponse = buildErrorGenericResponse(extractDetailedMessage(ex),
            HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException ex) {
        log.error("inside  handleMethodArgumentNotValidException", ex);
        ErrorResponse errorResponse =
            buildErrorGenericResponse(
                ex.getBindingResult().getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(java.util.stream.Collectors.joining(", ")), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMessageNotRead(HttpMessageNotReadableException ex) {
        log.error("inside  handleMessageNotRead", ex);
        ErrorResponse errorResponse = buildErrorGenericResponse(extractDetailedMessage(ex),
            HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleJsonProcessingException(
        final JsonProcessingException ex) {
        log.error("inside handleJsonProcessingException", ex);
        ex.printStackTrace();
        ErrorResponse errorResponse =
            buildErrorGenericResponse(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private String extractDetailedMessage(Throwable e) {
        final String message = e.getMessage();
        if (message == null) {
            return "";
        }
        final int tailIndex = StringUtils.indexOf(message, ":");
        if (tailIndex == -1) {
            return message;
        }
        return StringUtils.append(message, String.valueOf(tailIndex));
    }
}
