package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingRequestDto {
    private final List<String> carNames;
    private final int racingTryTime;

    public CarRacingRequestDto(List<String> carNames, int racingTryTime) {
        this.carNames = new ArrayList<>(carNames);
        this.racingTryTime = racingTryTime;
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int getRacingTryTime() {
        return racingTryTime;
    }
}
