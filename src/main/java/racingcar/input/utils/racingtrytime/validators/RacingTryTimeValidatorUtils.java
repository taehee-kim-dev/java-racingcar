package racingcar.input.utils.racingtrytime.validators;

import racingcar.input.utils.racingtrytime.validators.exceptions.NotNaturalNumberRacingTimeException;

public class RacingTryTimeValidatorUtils {
    private final String ERROR_MESSAGE = "경주 시도 횟수는 자연수여야 합니다.";
    private final int MIN_NATURAL_NUMBER = 1;

    private RacingTryTimeValidatorUtils() {
    }

    public static void validateNaturalNumberRacingTime(String racingTime) {
        try {
            int integerConvertedRacingTime = Integer.parseInt(racingTime);
            validateOneOrMoreRacingTime(integerConvertedRacingTime);
        } catch (Exception e) {
            throw new NotNaturalNumberRacingTimeException(ERROR_MESSAGE);
        }
    }

    private static void validateOneOrMoreRacingTime(int integerConvertedRacingTime) {
        if (integerConvertedRacingTime < MIN_NATURAL_NUMBER) {
            throw new NotNaturalNumberRacingTimeException(ERROR_MESSAGE);
        }
    }
}
