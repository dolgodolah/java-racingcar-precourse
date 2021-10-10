package racinggame.ui;

import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.List;

public class Output {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String START_MESSAGE = "실행 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "최종 우승자는 ";
    private static final String RESULT_SUFFIX = " 입니다.";

    public static void printRequestCarNameMessage() {
        System.out.println(REQUEST_CAR_NAME);
    }

    public static void printRequestTryCountMessage() {
        System.out.println(REQUEST_TRY_COUNT);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printCarsStatus(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }
        System.out.println();
    }

    public static void printResult(String result) {
        System.out.println(RESULT_PREFIX + result + RESULT_SUFFIX);
    }
}
