package yeray.katas.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",";

    public int add(String input) {
        if (input.length() == 0)
            return 0;

        String parsedInput = parseDelimiters(input);

        String[] operands = parsedInput.split(DEFAULT_DELIMITER);

        return Arrays.stream(operands)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String parseDelimiters(String input) {
        return input.replace("\n", DEFAULT_DELIMITER);
    }

}
