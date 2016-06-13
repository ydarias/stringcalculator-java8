package yeray.katas.stringcalculator;

import yeray.katas.stringcalculator.exceptions.NegativeNumberException;

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
                .mapToInt(this::toPositiveIntegerValue)
                .filter(operand -> operand <= 1000)
                .sum();
    }

    private int toPositiveIntegerValue(String input) {
        int value = Integer.valueOf(input);

        if (value < 0)
            throw new NegativeNumberException();

        return value;
    }

}
