package yeray.katas.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyInputReturnsZero() throws Exception {

        assertEquals(0, calculator.add(""));
    }

    @Test
    public void sumsInputsOfLengthOne() throws Exception {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void sumsInputsOfLengthTwo() throws Exception {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void sumsInputsOfAnyLength() throws Exception {
        assertEquals(14, calculator.add("1,2,5,6"));
    }

    @Test
    public void sumsInputsUsingNewLineAsDelimiter() throws Exception {
        assertEquals(6, calculator.add("1\n2,3"));
    }

}