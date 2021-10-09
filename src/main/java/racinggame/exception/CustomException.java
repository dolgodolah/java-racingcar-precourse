package racinggame.exception;

public class CustomException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public CustomException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    }

    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
