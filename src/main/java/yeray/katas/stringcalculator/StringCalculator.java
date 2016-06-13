package yeray.katas.stringcalculator;

public class StringCalculator {

    public int add(String input) {
        if (input.length() == 1)
            return Integer.valueOf(input);

        return 0;
    }

}
