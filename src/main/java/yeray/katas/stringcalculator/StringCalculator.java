package yeray.katas.stringcalculator;

import yeray.katas.stringcalculator.exceptions.NegativeNumberException;

import java.util.Arrays;

public class StringCalculator {

    private StringCalculatorParser parser = new StringCalculatorParser();

    public int add(String input) {
        if (input.length() == 0)
            return 0;

        String[] operands = parser.getOperands(input);

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
