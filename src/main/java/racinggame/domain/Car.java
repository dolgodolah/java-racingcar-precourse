package racinggame.domain;

public class Car {

    private CarName carName;
    private ProgressBar progressBar;

    public Car(CarName name) {
        this.carName = name;
        this.progressBar = new ProgressBar();
    }

    public void forward() {
        this.progressBar.forward();
    }

    public String getCarName() {
        return carName.getName();
    }

    public String getProgressBar() {
        return progressBar.toString();
    }

    @Override
    public String toString() {
        return carName.getName() + ":" + progressBar.toString();
    }
}
