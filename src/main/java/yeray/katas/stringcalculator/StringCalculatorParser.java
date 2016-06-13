package yeray.katas.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorParser {

    private static final String DEFAULT_DELIMITER = ",";

    public String[] getOperands(String input) {
        String parsedInput = replaceDelimitersByDefaultDelimiter(input);

        return parsedInput.split(DEFAULT_DELIMITER);
    }

    private String replaceDelimitersByDefaultDelimiter(String input) {
        if (input.startsWith("//"))
            return replaceCustomDelimitersByDefaultDelimiter(input);

        return input.replace("\n", DEFAULT_DELIMITER);
    }

    private String replaceCustomDelimitersByDefaultDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.*?)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        matcher.find();

        String operandsString = matcher.group(2);
        for (String customDelimiter : customDelimitersAsTokens(matcher.group(1)))
            operandsString = operandsString.replace(customDelimiter, DEFAULT_DELIMITER);

        return operandsString;
    }

    private List<String> customDelimitersAsTokens(String customDelimiters) {
        String[] tokens =  customDelimiters
                .replaceAll("\\]\\[", "|")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split("\\|");

        return Arrays.asList(tokens);
    }

}
