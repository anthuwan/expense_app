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
package expense.calculator.app.exception;


import expense.calculator.app.domain.CommonResponse;

public class ExpenseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final CommonResponse response;

    public ExpenseException(CommonResponse response) {
        this.response = response;
    }

    public ExpenseException(String message, String code, String description,
                                   int statusCode) {
        this.response = new CommonResponse();
        this.response.code(code)
            .statusCode(statusCode)
            .message(message)
            .description(description);
    }

    public CommonResponse getResponse() {
        return response;
    }

    public String getCode() {
        return response.getCode();
    }

    public String getDescription() {
        return response.getDescription();
    }

    @Override
    public String getMessage() {
        return response.getMessage();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
