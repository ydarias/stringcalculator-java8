package yeray.katas.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String input) {
        if (input.length() == 0)
            return 0;

        String[] operands = input.split(",");

        return Arrays.stream(operands)
                .mapToInt(Integer::valueOf)
                .sum();
    }

}
