package racinggame.ui;

import nextstep.utils.Console;

public class Input {

    public static String[] inputCars() {
        Output.printRequestCarNameMessage();
        return Console.readLine().split(",");
    }

    public static String inputTryCount() {
        Output.printRequestTryCountMessage();
        return Console.readLine();
    }
}
