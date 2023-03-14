package models;

import interfaces.ICalculator;

public final class Calculator implements ICalculator{
    private static Calculator calculator;

    /**
     * singleton return instance of calculator
     * @return
     */
    public static Calculator getInstance(){
        if(calculator == null){
            calculator = new Calculator();
        }
        return calculator;
    }

    /**
     * add two numbers
     */
    @Override
    public double add(double a, double b) {
        // TODO Auto-generated method stub
        double result = a+b;
        return result;
    }

    /**
     * substract two numbers
     */
    @Override
    public double subtraction(double a, double b) {
        // TODO Auto-generated method stub
        double result = a-b;
        return result;
    }

    /**
     * multiply two numbers
     */
    @Override
    public double multiplication(double a, double b) {
        // TODO Auto-generated method stub
        double result = a*b;
        return result;
    }

    /**
     * divide two numbers
     */
    @Override
    public double division(double a, double b) {
        // TODO Auto-generated method stub
        double result = a/b;
        return result;
    }

    
}