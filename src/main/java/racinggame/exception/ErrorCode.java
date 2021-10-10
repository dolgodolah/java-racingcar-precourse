package racinggame.exception;

public enum ErrorCode {

    INVALID_NAME_LENGTH("자동차 이름은 최대 5자입니다. 다시 입력해주세요."),
    INVALID_TRY_COUNT("시도 회수는 숫자로 입력해주세요.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
