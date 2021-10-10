package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;
import racinggame.ui.Input;
import racinggame.ui.Output;

import java.util.List;

public class RacingManager {

    private Cars cars;
    private TryCount tryCount;
    private Status status;

    enum Status {
        READY
    }

    public void initRacing() {
        try {
            initCars();
            inputTryCount();
            ready();
        } catch (CustomException e) {
            Output.printErrorMessage(e.getMessage());
        }
    }

    public void startRacing() {
        Output.printStartMessage();
        for (int i = 0; i < tryCount.get(); i++) {
            cars.race();
            cars.viewStatus();
        }
    }

    public void viewResult() {
        List<Car> winners = cars.getWinners();
        Result result = new Result(winners);
        Output.printResult(result.toString());
    }

    private void initCars() {
        cars = new Cars();
        String[] input = Input.inputCars();
        for (int i = 0; i < input.length; i++) {
            Car car = new Car(input[i]);
            cars.add(car);
        }
    }

    private void inputTryCount() {
        String input = Input.inputTryCount();
        tryCount = TryCount.of(input);
    }

    public boolean isReady() {
        return this.status == Status.READY;
    }

    private void ready() {
        this.status = Status.READY;
    }
}
