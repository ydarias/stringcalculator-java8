package yeray.katas.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String operandsString = matcher.group(2);
            String customDelimiter = matcher.group(1);

            return operandsString.replace(customDelimiter, DEFAULT_DELIMITER);
        } else {
            return input.replace("\n", DEFAULT_DELIMITER);
        }
    }

}
