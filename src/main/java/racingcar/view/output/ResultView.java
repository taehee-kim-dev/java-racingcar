package racingcar.view.output;

import static racingcar.view.input.carname.RawCarNamesInputFromUser.CAR_NAMES_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class ResultView {
    private static final String POSITION_SIGN = "-";

    public ResultView() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        cars.forEach(this::printEachCarCurrentPosition);
        printNewLine();
    }

    private void printEachCarCurrentPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SIGN);
        }
        printNewLine();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        System.out.print(String.join(CAR_NAMES_DELIMITER + " ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    public void printNewLine() {
        System.out.print("\n");
    }
}
