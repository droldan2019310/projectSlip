import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.stream.Collectors;

import maps.HashMapClass;
import models.Calculator;
import models.KeyWords;
import stacks.Stack;

public class App {

    HashMapClass<String> stringVariables = new HashMapClass<String>();
    HashMapClass<Boolean> booleanVariables = new HashMapClass<Boolean>();
    HashMapClass<Double> doubleVariables = new HashMapClass<Double>();


    Stack<String> stackToken = new Stack<String>();
    Stack<Double> stackNumbers = new Stack<Double>();


    KeyWords keyWords = new KeyWords();
    String actualName;


    private Calculator calculator;

    public static void main(String[] args) throws Exception {
        App app =  new App();

        app.start();
    }


    public void start(){
        calculator = Calculator.getInstance();
        readFile();
    }



    /**
     * read file in assets/file.txt
     */
    public void readFile(){
        File file = new File("src/program.txt");
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            
            
            String data =  br.lines().collect(Collectors.joining());
            data = data.replace("\n", "").replace("\r", "");
            getTokens(data);

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }

  
    public void getTokens(String data){
        
        stackToken =  keyWords.separateWithPairs(data);
        

        try {
            validateCharacter();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void validateCharacter() throws Exception{
        while(stackToken.size()!=0){
            String token = stackToken.pop();
            if(token.equals("(")){
                
                token = stackToken.pop();
                switch(token){
                    case "setq":
                        stackToken.pop();
                        stackToken.pop();
                        stackToken.pop();

                        actualName = stackToken.pop();   
                        if(actualName.length()>1){
                            int x= actualName.length();

                            while(x>1){
                                stackToken.pop();
                                x--;
                            }
                        }
                        if(stackToken.peek().equals("(")){
                        }else{
                            String value = stackToken.pop();

                            try { 
                                double  number = Double.parseDouble(value); 
                                doubleVariables.add(actualName,number);
                                actualName = "";
                            } catch(NumberFormatException e) { 
                                stringVariables.add(actualName,value);
                                actualName = "";
                            }   
                        }

                        break;
                    
                    case "+":
                        try{
                            double item1 = Double.parseDouble(stackToken.pop());
                            double item2 = Double.parseDouble(stackToken.pop());
                            double result = calculator.add(item1, item2);
                            if(!actualName.equals("")){
                                doubleVariables.add(actualName,result);
                                actualName = "";
                            }
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                            throw new Exception("NOT A NUMBER");
                        }
                        break;
                    case "-":
                        try{
                            double item1 = Double.parseDouble(stackToken.pop());
                            double item2 = Double.parseDouble(stackToken.pop());
                            double result = calculator.subtraction(item1, item2);
                            if(!actualName.equals("")){
                                doubleVariables.add(actualName, result);
                                actualName = "";
                            }

                        }catch(NumberFormatException e){
                            e.printStackTrace();
                            throw new Exception("NOT A NUMBER");
                        } 
                        break;
                    case "/":
                        
                        break;
                    case "*":
                        
                        break;
                    case "print":
                        stackToken.pop();
                        stackToken.pop();
                        stackToken.pop();
                        stackToken.pop();
                        
                        String value = stackToken.pop();
                        if(value.equals("+") || value.equals("/") || value.equals("-") || value.equals("*")) {
                        }else{
                            try{
                                double d = Double.parseDouble(value);
                                System.out.println(d);
                            }catch(NumberFormatException e){
                                boolean flag =  keyWords.print(value);
                                if(!flag){

                                    if(stringVariables.getValue(value)!=null){
                                        System.out.println(stringVariables.getValue(value));
                                        
                                    }

                                    if(doubleVariables.getValue(value)!=null){
                                        System.out.println(doubleVariables.getValue(value));
                                    }

                                    if(booleanVariables.getValue(value)!=null){
                                        System.out.println(booleanVariables.getValue(value));
                                    }

                                    if(value.length()>1){
                                        int x= value.length();
            
                                        while(x>1){
                                            stackToken.pop();
                                            x--;
                                        }
                                    }

                                }
                            }
                        }

                        break;
                    default:
                        break;
                }
            }else{
                if(!token.equals(")")){
                    throw new Exception("NO COMIENZA CON PARENTESIS");
                }
            }
        
        }
            
    }


    
   
}
