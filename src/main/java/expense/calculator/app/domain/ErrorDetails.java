package expense.calculator.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * ErrorDetails
 */

public class ErrorDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String description;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ErrorDetails#ErrorDetails(String, String)}
     */
    @Deprecated
    public ErrorDetails() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ErrorDetails(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ErrorDetails code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */
    @NotNull
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorDetails description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @NotNull
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) o;
        return Objects.equals(this.code, errorDetails.code) &&
            Objects.equals(this.description, errorDetails.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorDetails {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

