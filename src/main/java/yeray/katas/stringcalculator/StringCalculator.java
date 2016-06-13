package yeray.katas.stringcalculator;

public class StringCalculator {

    public int add(String input) {
        if (input.length() == 3)
            return Integer.valueOf(input.substring(0, 1)) + Integer.valueOf(input.substring(2, 3));

        if (input.length() == 1)
            return Integer.valueOf(input);

        return 0;
    }

}
