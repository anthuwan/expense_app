
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
