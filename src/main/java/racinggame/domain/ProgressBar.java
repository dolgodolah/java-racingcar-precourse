package racinggame.domain;

public class ProgressBar {

    private final static String BAR = "-";

    private StringBuilder progressBar;

    public ProgressBar() {
        this.progressBar = new StringBuilder();
    }

    public void forward() {
        this.progressBar.append(BAR);
    }

    public StringBuilder get() {
        return progressBar;
    }

    @Override
    public String toString() {
        return progressBar.toString();
    }
}
