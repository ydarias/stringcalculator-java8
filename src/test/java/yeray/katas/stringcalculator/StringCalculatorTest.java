package yeray.katas.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void emptyInputReturnsZero() throws Exception {
        StringCalculator calculator = new StringCalculator();

        assertEquals(0, calculator.add(""));
    }

    @Test
    public void sumsInputsOfLengthOne() throws Exception {
        StringCalculator calculator = new StringCalculator();

        assertEquals(1, calculator.add("1"));
    }

}