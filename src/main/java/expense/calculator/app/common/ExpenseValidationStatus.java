

package expense.calculator.app.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ExpenseValidationStatus {
    UNAUTHORIZED(401, "CREDENTIALS_INVALID", ""),
    BADREQUEST(400, "Invalid request format.", "ERR_001"),
    FORBIDDEN(403, "Forbidden", "Forbidden"),
    RESOURCENOTFOUND(404, "RESOURCE_NOT_FOUND", ""),
    INTERNALSERVERERROR(500, "INTERNAL_SERVER_ERROR", "");

    private final int statusCode;
    private final String statusDescription;

    private final String code;

    ExpenseValidationStatus(int statusCode, String statusDescription, String code) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.code = code;
    }

    public static String fromValue(int text) {
        for (ExpenseValidationStatus b : ExpenseValidationStatus.values()) {
            if (String.valueOf(b.statusCode).equals(String.valueOf(text))) {
                return b.statusDescription;
            }
        }
        return null;
    }

    public static String getCode(int text) {
        for (ExpenseValidationStatus b : ExpenseValidationStatus.values()) {
            if (String.valueOf(b.statusCode).equals(String.valueOf(text))) {
                return b.getCode();
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(statusCode);
    }
}
