package expense.calculator.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * ErrorResponse
 */


public class ErrorResponse extends CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<@Valid ErrorDetails> errors = new ArrayList<>();

    @Deprecated
    public ErrorResponse() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ErrorResponse(List<@Valid ErrorDetails> errors, String responseType, UUID xrequestId,
        String message, String code, Integer statusCode, String description) {
        super(responseType, xrequestId, message, code, statusCode, description);
        this.errors = errors;
    }

    public ErrorResponse errors(List<@Valid ErrorDetails> errors) {
        this.errors = errors;
        return this;
    }

    public ErrorResponse addErrorsItem(ErrorDetails errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Get errors
     *
     * @return errors
     */
    @NotNull
    @Valid
    @JsonProperty("errors")
    public List<@Valid ErrorDetails> getErrors() {
        return errors;
    }

    public void setErrors(List<@Valid ErrorDetails> errors) {
        this.errors = errors;
    }

    public ErrorResponse responseType(String responseType) {
        super.setResponseType(responseType);
        return this;
    }

    public ErrorResponse xrequestId(UUID xrequestId) {
        super.setXrequestId(xrequestId);
        return this;
    }

    public ErrorResponse message(String message) {
        super.setMessage(message);
        return this;
    }

    public ErrorResponse code(String code) {
        super.setCode(code);
        return this;
    }

    public ErrorResponse statusCode(Integer statusCode) {
        super.setStatusCode(statusCode);
        return this;
    }

    public ErrorResponse description(String description) {
        super.setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equals(this.errors, errorResponse.errors) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorResponse {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

