package interfaces;
/**

 Interface for a basic calculator that performs arithmetic operations.
 */
public interface ICalculator {
    /**

     Adds two numbers.
     @param a the first number to add
     @param b the second number to add
     @return the sum of a and b
     */
    public double  add(double a, double b);
    /**

    Subtracts two numbers.
    @param a the number to subtract from
    @param b the number to subtract
    @return the result of subtracting b from a
    */
    public double  subtraction(double a, double b);
    /**

     Multiplies two numbers.
     @param a the first number to multiply
     @param b the second number to multiply
     @return the product of a and b
     */
    public double  multiplication(double a, double b);
    /**

     Divides two numbers.
     @param a the number to divide
     @param b the divisor
     @return the result of dividing a by b
     @throws ArithmeticException if b is zero
     */
    public double  division(double a, double b);
}
