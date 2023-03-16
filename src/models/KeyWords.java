package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.IKeyWords;
import stacks.Stack;
/**

 KeyWords is an implementation of the IKeyWords interface.

 */
public class KeyWords implements IKeyWords{
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void commentNestable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commentNestable'");
    }
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void commentEndLine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commentEndLine'");
    }
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void greaterThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'greaterThan'");
    }
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void lowerThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lowerThan'");
    }
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void greaterIqualThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'greaterIqualThan'");
    }

    @Override
    public void lowerIqualThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lowerIqualThan'");
    }
    /**

     Throws an UnsupportedOperationException because the method is unimplemented.
     */
    @Override
    public void defun() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defun'");
    }

    @Override
    public void equal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equal'");
    }

     @Override
    public void equalP() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equalP'");
    }

    @Override
    public void setQ() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setQ'");
    }

    @Override
    public void setF() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setF'");
    }

    @Override
    public void set() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void cond() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cond'");
    }

    @Override
    public void loop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loop'");
    }
    /**

     Esta clase implementa el método separateWithPairs, que toma una cadena de texto y separa sus elementos en una pila.
     Los elementos se separan en función de distintos patrones de caracteres

     */
    @Override
    public Stack<String> separateWithPairs(String string) {
        // TODO Auto-generated method stub
        String patternLetters = "[a-zA-Z]";
        String patternLettersNumbers = "[a-zA-Z0-9]+";
        String patternAtom = "[\\d\\+\\-]?[\\d]*";
        String patternQuote = "[\"]";
        String patternComment = "[;]";
        String patternSymbol = "[().]";

        Stack<String> pairs = new Stack<String>();

        
        //run all the string
        int y;
        for(int x=0; x<string.length();x++){
            y =x+1;
            if(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote) || string.substring(x, y).matches(patternComment)){
                while(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote) || string.substring(x, y).matches(patternComment)){
                    y++;
                }
                pairs.push(string.substring(x, y-1));
            }else if(string.substring(x, y).matches(patternSymbol)){
                pairs.push(string.substring(x, y));
            }
        }
       

        return pairs;
    }
    /**

     Prints a string value if it is enclosed in double quotes.
     @param value a string to be printed
     @return true if the string value is enclosed in double quotes, false otherwise
     */
    @Override
    public boolean print(String value) {
        // TODO Auto-generated method stub

            if(value.substring(0).equals("\"") && value.substring(value.length()).equals("\"")){
                value = value.replaceAll("\"", value);
                System.out.println(value);
                return true;
            }else{
                return false;
            }
        
    }
    

    

    
}
