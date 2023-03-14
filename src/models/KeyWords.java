package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.IKeyWords;
import stacks.Stack;

public class KeyWords implements IKeyWords{
    
    @Override
    public void commentNestable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commentNestable'");
    }

    @Override
    public void commentEndLine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commentEndLine'");
    }

    @Override
    public void greaterThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'greaterThan'");
    }

    @Override
    public void lowerThan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lowerThan'");
    }

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

    @Override
    public Stack<String> separateWithPairs(String string) {
        // TODO Auto-generated method stub
        String patternLetters = "[a-zA-Z]";
        String patternLettersNumbers = "[a-zA-Z0-9]+";
        String patternAtom = "[\\d\\+\\-]?[\\d]*";
        String patternQuote = "[\"]";
        String patternSymbol = "[().]";

        Stack<String> pairs = new Stack<String>();

        
        //run all the string
        int y;
        for(int x=0; x<string.length();x++){
            y =x+1;
            if(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote)){
                while(string.substring(x, y).matches(patternLetters) || string.substring(x, y).matches(patternLettersNumbers) || string.substring(x, y).matches(patternAtom) || string.substring(x, y).matches(patternQuote)){
                    y++;
                }
                pairs.push(string.substring(x, y-1));
            }else if(string.substring(x, y).matches(patternSymbol)){
                pairs.push(string.substring(x, y));
            }
        }
       

        return pairs;
    }

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
