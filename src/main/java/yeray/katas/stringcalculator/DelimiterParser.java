package yeray.katas.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    public String parse(String input, String defaultDelimiter) {
        if (input.startsWith("//"))
            return parseCustomDelimiter(input, defaultDelimiter);

        return input.replace("\n", defaultDelimiter);
    }

    private String parseCustomDelimiter(String input, String defaultDelimiter) {
        Pattern pattern = Pattern.compile("//(.*?)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        matcher.find();

        String operandsString = matcher.group(2);
        for (String customDelimiter : parseCustomDelimiters(matcher.group(1)))
            operandsString = operandsString.replace(customDelimiter, defaultDelimiter);

        return operandsString;
    }

    private List<String> parseCustomDelimiters(String customDelimiters) {
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
