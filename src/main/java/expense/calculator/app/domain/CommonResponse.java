package expense.calculator.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * CommonResponse
 */

@JsonIgnoreProperties(
    value = "responseType",
    allowSetters = true
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "responseType", visible = true)
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String responseType;

    private UUID xrequestId;

    private String message;

    private String code;

    private Integer statusCode;

    private String description;

    /**
     * Default constructor
     *
     * @deprecated Use
     * {@link CommonResponse#CommonResponse(String, UUID, String, String, Integer, String)}
     */
    @Deprecated
    public CommonResponse() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public CommonResponse(String responseType, UUID xrequestId, String message, String code,
        Integer statusCode, String description) {
        this.responseType = responseType;
        this.xrequestId = xrequestId;
        this.message = message;
        this.code = code;
        this.statusCode = statusCode;
        this.description = description;
    }

    public CommonResponse responseType(String responseType) {
        this.responseType = responseType;
        return this;
    }

    /**
     * Get responseType
     *
     * @return responseType
     */
    @NotNull
    @JsonProperty("responseType")
    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public CommonResponse xrequestId(UUID xrequestId) {
        this.xrequestId = xrequestId;
        return this;
    }

    /**
     * Get xrequestId
     *
     * @return xrequestId
     */
    @NotNull
    @Valid
    @JsonProperty("xrequestId")
    public UUID getXrequestId() {
        return xrequestId;
    }

    public void setXrequestId(UUID xrequestId) {
        this.xrequestId = xrequestId;
    }

    public CommonResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     */
    @NotNull
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommonResponse code(String code) {
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

    public CommonResponse statusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Get statusCode
     *
     * @return statusCode
     */
    @NotNull
    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public CommonResponse description(String description) {
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
        CommonResponse commonResponse = (CommonResponse) o;
        return Objects.equals(this.responseType, commonResponse.responseType) &&
            Objects.equals(this.xrequestId, commonResponse.xrequestId) &&
            Objects.equals(this.message, commonResponse.message) &&
            Objects.equals(this.code, commonResponse.code) &&
            Objects.equals(this.statusCode, commonResponse.statusCode) &&
            Objects.equals(this.description, commonResponse.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseType, xrequestId, message, code, statusCode, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommonResponse {\n");
        sb.append("    responseType: ").append(toIndentedString(responseType)).append("\n");
        sb.append("    xrequestId: ").append(toIndentedString(xrequestId)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

