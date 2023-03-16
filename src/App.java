import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.stream.Collectors;

import maps.HashMapClass;
import models.Calculator;
import models.KeyWords;
import stacks.Stack;

public class App {
    /**

     HashMapClass instance for storing variables of type String.
     */
    HashMapClass<String> stringVariables = new HashMapClass<String>();
    /**

     HashMapClass instance for storing variables of type Boolean.
     */
    HashMapClass<Boolean> booleanVariables = new HashMapClass<Boolean>();
    /**

     HashMapClass instance for storing variables of type Double.
     */
    HashMapClass<Double> doubleVariables = new HashMapClass<Double>();

    /**

     Stack instance for storing tokens.
     */
    Stack<String> stackToken = new Stack<String>();
    /**

     Stack instance for storing numbers.
     */
    Stack<Double> stackNumbers = new Stack<Double>();

    /**

     KeyWords instance for performing operations on variables.
     */
    KeyWords keyWords = new KeyWords();
    /**

     String variable to store the name of the current variable being used.
     */
    String actualName;


    private Calculator calculator;
    /**

     @param args command line arguments.
     @throws Exception if an error occurs while executing the application.
     */
    public static void main(String[] args) throws Exception {
        App app =  new App();

        app.start();
    }

    /**

     Initializes the calculator instance and reads the file to perform calculations.
     */
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
            
            
            
            
            RandomAccessFile raf=new RandomAccessFile(file,"r");
            String text="";
            for(String line=raf.readLine();line!=null;line=raf.readLine()){
                text+=line+System.lineSeparator();
            }
            getTokens(text);

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }

    /**

     @param data the string of data to extract the tokens from.
     @throws Exception if the validateCharacter method throws an exception.
     */
    public void getTokens(String data){
        
        stackToken =  keyWords.separateWithPairs(data);
         int x=0;
         while(x != stackToken.size()){
             System.out.println("PRINT: "+ stackToken.getvalue(x));
             x++;
         }
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
                        try{
                            double item1 = Double.parseDouble(stackToken.pop());
                            double item2 = Double.parseDouble(stackToken.pop());
                            double result = calculator.division(item1, item2);
                            if(!actualName.equals("")){
                                doubleVariables.add(actualName,result);
                                actualName = "";
                            }
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                            throw new Exception("NOT A NUMBER");
                        }
                        break;
                    case "*":
                        try{
                            double item1 = Double.parseDouble(stackToken.pop());
                            double item2 = Double.parseDouble(stackToken.pop());
                            double result = calculator.multiplication(item1, item2);
                            if(!actualName.equals("")){
                                doubleVariables.add(actualName,result);
                                actualName = "";
                            }
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                            throw new Exception("NOT A NUMBER");
                        }
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
                                if(value.equals("\"")){
                                    
                                    value = stackToken.pop();
                                    int x=0;
                                    while(x<value.length()-1){
                                        stackToken.pop();
                                        x++;
                                    }

                                    String finishValue = stackToken.pop();
                                    while(!finishValue.equals("\"")){
                                        if(stackToken.size()==0){
                                            break;
                                        }else{
                                            value = value + " "+ finishValue;
                                            x=0;
                                            while(x<finishValue.length()-1){
                                                stackToken.pop();
                                                x++;
                                            }
                                            finishValue = stackToken.pop();
                                        }
                                    }

                                    System.out.println(value);
                                    
                                }else{
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
                    case";":
                        boolean foundNewLine = false;
                        while(!stackToken.empty()){
                            actualName = stackToken.pop();
                            if (actualName == ("/n")){
                                foundNewLine = true;
                                break;
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
