package yeray.katas.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorParser {

    private static final String DEFAULT_DELIMITER = ",";

    public String[] getOperands(String input) {
        String parsedInput = replaceInputByDefaultDelimiter(input);

        return parsedInput.split(DEFAULT_DELIMITER);
    }

    private String replaceInputByDefaultDelimiter(String input) {
        if (input.startsWith("//"))
            return parseCustomDelimiters(input, DEFAULT_DELIMITER);

        return input.replace("\n", DEFAULT_DELIMITER);
    }

    private String parseCustomDelimiters(String input, String defaultDelimiter) {
        Pattern pattern = Pattern.compile("//(.*?)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        matcher.find();

        String operandsString = matcher.group(2);
        for (String customDelimiter : customDelimitersAsTokens(matcher.group(1)))
            operandsString = operandsString.replace(customDelimiter, defaultDelimiter);

        return operandsString;
    }

    private List<String> customDelimitersAsTokens(String customDelimiters) {
        if (customDelimiters.contains("[")) {
            return Arrays.asList(
                customDelimiters
                        .replaceAll("\\]\\[", "|")
                        .replaceAll("\\[", "")
                        .replaceAll("\\]", "")
                        .split("\\|"));
        } else {
            return Arrays.asList(customDelimiters);
        }
    }

}
