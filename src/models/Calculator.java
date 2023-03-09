import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

package models;

public class Calculator {
    public static void main(String[] args){
        String dataName = "datos.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(dataName))){
            String line;
            while ((line = reader.readLine()) != null){
                int result = evaluatePostfix(line);
                System.out.println(line +"="+result);
            }

        }catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static int evaluatePostfix(String expression){
        Stack<Integer> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(c-'0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/'){
                int operando2 = stack.pop();
                int operando1 = stack.pop();
                int result = applyOperando(c, operando1, operando2);
                stack.push(result);
            }
        }
        return stack.pop();


    }

    public static int applyOperando(char operator, int operando1, int operando2){
        switch (operator){
            case '+':
                return operando1 + operando2;
            case'-':
                return operando1 - operando2;
            case'*':
                return operando1 * operando2;
            case '/':
                return operando1 / operando2;
            default: 
                throw new IllegalArgumentException("Uknow operator: " + operator);
            
            



        }



    }
}
