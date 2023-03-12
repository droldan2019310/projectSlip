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
    public float add(float a, float b) {
        // TODO Auto-generated method stub
        float result = a+b;
        return result;
    }

    /**
     * substract two numbers
     */
    @Override
    public float subtraction(float a, float b) {
        // TODO Auto-generated method stub
        float result = a-b;
        return result;
    }

    /**
     * multiply two numbers
     */
    @Override
    public float multiplication(float a, float b) {
        // TODO Auto-generated method stub
        float result = a*b;
        return result;
    }

    /**
     * divide two numbers
     */
    @Override
    public float division(float a, float b) {
        // TODO Auto-generated method stub
        float result = a/b;
        return result;
    }

    /**
     * method not used
     */
    @Override
    public void getNextImput() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextImput'");
    }
    
}