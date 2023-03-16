package interfaces;

import stacks.Stack;
/**

 This interface defines the keywords
 */
public interface IKeyWords {
    /**

     This method represents a nestable comment keyword.
     */
    public void commentNestable();
    /**

     This method represents an end-line comment keyword.
     */
    public void commentEndLine();
    /**

     This method represents a greater-than keyword.
     */
    public void greaterThan();
    /**

     This method represents a lower-than keyword.
     */
    public void lowerThan();
    /**

     This method represents a greater-than-or-equal-to keyword.
     */
    public void greaterIqualThan();
    /**

     This method represents a lower-than-or-equal-to keyword.
     */
    public void lowerIqualThan();
    /**

     This method represents a defun keyword.
     */
    public void defun();
    /**

     This method represents an equal keyword.
     */
    public void equal();
    /**

     This method represents an equalP keyword.
     */
    public void equalP();
    /**

     This method represents a setQ keyword.
     */
    public void setQ();
    /**

     This method represents a setF keyword.
     */
    public void setF();
    /**

     This method represents a set keyword.
     */
    public void set();
    /**

     This method represents a cond keyword.
     */
    public void cond();
    /**

     This method represents a loop keyword.
     */
    public void loop();
    /**

     This method prints a given string value.
     @param value the string value to be printed.
     @return true if the printing was successful, false otherwise.
     */
    public boolean print(String value);
    /**

     This method separates a given string into a stack of substrings.
     @param string the string to be separated.
     @return a stack of substrings.
     */
    public Stack<String> separateWithPairs(String string);
}






