package yeray.katas.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",";

    private DelimiterParser delimiterParser = new DelimiterParser();

    public int add(String input) {
        if (input.length() == 0)
            return 0;

        String parsedInput = delimiterParser.parse(input, DEFAULT_DELIMITER);

        String[] operands = parsedInput.split(DEFAULT_DELIMITER);

        return Arrays.stream(operands)
                .mapToInt(Integer::valueOf)
                .sum();
    }

}
