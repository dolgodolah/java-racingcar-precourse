package racinggame;

import racinggame.domain.RacingManager;

public class Application {
    public static void main(String[] args) {
        RacingManager racingManager = new RacingManager();

        racingManager.initRacing();
        racingManager.startRacing();
        racingManager.viewResult();
    }
}
