package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;

public class TryCount {

    private int count;

    public TryCount(int count) {
        this.count = count;
    }

    public static TryCount of(String value) {
        try {
            return new TryCount(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorCode.INVALID_TRY_COUNT);
        }
    }

    public int get() {
        return count;
    }
}
