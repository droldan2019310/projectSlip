package test;

import static org.junit.Assert.*;
import org.junit.Test;

import models.Calculator;

public class CalculatorTest {
    @Test
    public void addTest(){
        Calculator calculator = Calculator.getInstance();
        assertEquals(2.0, calculator.add(1, 1),0.2);
    }

    @Test
    public void substractTest(){
        Calculator calculator = Calculator.getInstance();
        assertEquals(2.0, calculator.subtraction(4, 2),0.2);
    }


    @Test
    public void multiplyTest(){
        Calculator calculator = Calculator.getInstance();
        assertEquals(8.0, calculator.multiplication(4, 2),0.2);
    }

    @Test
    public void divideTest(){
        Calculator calculator = Calculator.getInstance();
        assertEquals(2.0, calculator.division(4, 2),0.2);
    }
}
