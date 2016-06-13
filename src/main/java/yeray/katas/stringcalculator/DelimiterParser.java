package yeray.katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    public String parse(String input, String defaultDelimiter) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String operandsString = matcher.group(2);
            String customDelimiter = matcher.group(1);

            return operandsString.replace(customDelimiter, defaultDelimiter);
        } else {
            return input.replace("\n", defaultDelimiter);
        }
    }

}
