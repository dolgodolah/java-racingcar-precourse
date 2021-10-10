package racinggame.domain;

public class Move {

    private int value;

    public Move(int value) {
        this.value = value;
    }

    public boolean isForward() {
        return value > 3;
    }
}
