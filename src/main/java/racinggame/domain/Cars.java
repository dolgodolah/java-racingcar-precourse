package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public List<Car> get() {
        return cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Move move = new Move(Randoms.pickNumberInRange(0, 9));
            cars.get(i).forwardOrStop(move);
        }
    }

    public void viewStatus() {
        Output.printCarsStatus(cars);
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        String maxProgressBar = getMaxProgressBar();
        for (int i = 0; i < cars.size(); i++) {
            addIfMaxProgressBar(winners, maxProgressBar, cars.get(i));
        }

        return winners;
    }

    private void addIfMaxProgressBar(List<Car> winners, String maxProgressBar, Car car) {
        if (car.getProgressBar().equals(maxProgressBar))
            winners.add(car);
    }

    private String getMaxProgressBar() {
        String maxProgressBar = "";
        for (int i = 0; i < cars.size(); i++) {
            String progressBar = cars.get(i).getProgressBar();
            maxProgressBar = compare(maxProgressBar, progressBar);
        }
        return maxProgressBar;
    }

    private String compare(String max, String value) {
        return value.length() > max.length() ? value : max;
    }
}
