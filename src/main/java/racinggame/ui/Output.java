package racinggame.ui;

public class Output {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT = "실행 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printRequestCarNameMessage() {
        System.out.println(REQUEST_CAR_NAME);
    }

    public static void printRequestTryCountMessage() {
        System.out.println(REQUEST_TRY_COUNT);
    }

    public static void printResultMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
