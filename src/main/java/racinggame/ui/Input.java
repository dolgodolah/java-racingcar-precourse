package racinggame.ui;

import nextstep.utils.Console;

public class Input {

    public static String inputCarName() {
        Output.printRequestCarNameMessage();
        return Console.readLine();
    }

    public static String inputTryCount() {
        Output.printRequestTryCountMessage();
        return Console.readLine();
    }
}
