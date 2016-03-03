package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/2.
 */
public class CalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(22, calculator.calculate("10 + 2 * 6"));
        assertEquals(212, calculator.calculate("100 * 2 + 12"));
        assertEquals(1400, calculator.calculate("100 * ( 2 + 12 )"));
        assertEquals(100, calculator.calculate("100 * ( 2 + 12 ) / 14"));
        assertEquals(2, calculator.calculate("(2)"));
//        System.out.println(EvaluateString.evaluate("10 + 2 * 6"));
//        System.out.println(EvaluateString.evaluate("100 * 2 + 12"));
//        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )"));
//        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}