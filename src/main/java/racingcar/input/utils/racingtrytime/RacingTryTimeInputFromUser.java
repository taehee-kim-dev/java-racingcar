package racingcar.input.utils.racingtrytime;

import java.util.Scanner;
import racingcar.input.printer.InputPrinter;
import racingcar.input.utils.racingtrytime.validators.RacingTryTimeValidatorUtils;

public class RacingTryTimeInputFromUser {
    private final Scanner scanner;

    public RacingTryTimeInputFromUser(Scanner scanner) {
        this.scanner = scanner;
    }
    public int getRacingTryTime() {
        InputPrinter.printRacingTryTimeInputMessage();
        String racingTryTimeInput = scanner.next();
        RacingTryTimeValidatorUtils.validateNaturalNumberRacingTime(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
