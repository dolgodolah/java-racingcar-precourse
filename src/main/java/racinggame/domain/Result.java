package racinggame.domain;

import java.util.List;

public class Result {

    private List<Car> winners;

    public Result(List<Car> winners) {
        this.winners = winners;
    }

    private boolean isSingleWinner() {
        return winners.size() == 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isSingleWinner()) {
            return winners.get(0).getCarName();
        }

        sb.append(winners.get(0).getCarName());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(",").append(winners.get(i).getCarName());
        }
        return sb.toString();
    }
}
