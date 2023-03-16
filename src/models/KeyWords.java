package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.IKeyWords;
import stacks.Stack;
/**

 KeyWords is an implementation of the IKeyWords interface.

 */
public class KeyWords implements IKeyWords{
    
   

    @Override
    public Stack<String> separateWithPairs(String string) {
        // TODO Auto-generated method stub
        String patternLetters = "[a-zA-Z]";
        String patternLettersNumbers = "[a-zA-Z0-9]+";
        String patternAtom = "[\\d\\+\\-]?[\\d]*";
        String patternQuote = "[\"]";
        String patternComment = "[;]";
        String patternSymbol = "[().]";
        String patternMayorMinor = "[><]";
        String patternarithmetic = "[+\\-*/]";
        Stack<String> pairs = new Stack<String>();

        
        //run all the string
        int y;
        for(int x=0; x<string.length();x++){
            y =x+1;
            if(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote) || string.substring(x, y).matches(patternMayorMinor) || string.substring(x, y).matches(patternarithmetic)){
                while(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote) || string.substring(x, y).matches(patternMayorMinor)
                || string.substring(x, y).matches(patternarithmetic)){
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
