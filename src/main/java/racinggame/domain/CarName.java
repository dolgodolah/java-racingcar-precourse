package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;

public class CarName {

    private final static int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.trim().length() > MAX_LENGTH) {
            throw new CustomException(ErrorCode.INVALID_NAME_LENGTH);
        }

        if (name.trim().isEmpty()) {
            throw new CustomException(ErrorCode.EMPTY_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
