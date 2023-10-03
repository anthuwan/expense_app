/*
 * InstaRem Overseas Money Transfer.
 *  https://www.instarem.com/en-in/
 *
 * Copyright (c) 2014-2020 InstaReM
 *
 * InstaRem is an acronym of Instant Remittance.
 * InstaRem Software is designed and developed to ease the Overseas Money Transfer.
 * It allows you to transfer your money overseas with minimum cost and time.
 *
 * This file is licensed and cannot be accessed by outside InstaRem.
 * It can only be accessed and modified by the authorized InstaRem Technical Teams.
 * If any unauthorized, outside of the InstaRem, user found to be unlawfully modified
 * the content of this file, will be prosecuted under the Copyright Act.
 */

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
