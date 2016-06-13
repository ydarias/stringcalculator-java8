package yeray.katas.stringcalculator;

import org.junit.Before;
import org.junit.Test;
import yeray.katas.stringcalculator.exceptions.NegativeNumberException;

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

    @Test
    public void sumsInputsUsingCustomDelimiter() throws Exception {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test(expected = NegativeNumberException.class)
    public void negativeNumbersGenerateException() throws Exception {
        calculator.add("1,-2,3");
    }

    @Test
    public void numbersLargerThanOneThousandAreIgnored() throws Exception {
        assertEquals(4, calculator.add("1,1001,3"));
    }

    @Test
    public void sumsInputsWithAnyLengthCustomDelimiter() throws Exception {
        assertEquals(6, calculator.add("//**\n1**2**3"));
    }

    @Test
    public void sumsInputsUsingMoreThanOneCustomDelimiter() throws Exception {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

}