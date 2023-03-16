package interfaces;

import stacks.Stack;
/**

 This interface defines the keywords
 */
public interface IKeyWords {
    
    

    /** This method prints a given string value.
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






