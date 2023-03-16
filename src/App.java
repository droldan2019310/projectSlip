import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.w3c.dom.Text;

import maps.HashMapClass;
import models.Calculator;
import models.KeyWords;
import stacks.Stack;

public class App {

    HashMapClass<String> stringVariables = new HashMapClass<String>();
    HashMapClass<Boolean> booleanVariables = new HashMapClass<Boolean>();
    HashMapClass<Double> doubleVariables = new HashMapClass<Double>();
    HashMapClass<String> defunVariables = new HashMapClass<String>();


    Stack<String> stackToken = new Stack<String>();
    Stack<Double> stackNumbers = new Stack<Double>();


    KeyWords keyWords = new KeyWords();
    String actualName="";
    String token;

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

  
    public void getTokens(String data){
        
        stackToken =  keyWords.separateWithPairs(data);
        //  int x=0;
        // while(x != stackToken.size()){
        //     System.out.println("PRINT: "+ stackToken.getvalue(x));
        //     x++;
        // }
        try {
            validateCharacter();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void validateCharacter() throws Exception{
        while(stackToken.size()!=0){
            token = stackToken.pop();
            if(token.equals("(")){
                token = stackToken.pop();
                switch(token){
                    case "setq":
                        setq();
                        break;
                    case "+":
                        add();
                        break;
                    case "-":
                        substract();
                        break;
                    case "/":
                        divide();
                        break;
                    case "*":
                        multiply();
                        break;
                    case "print":
                        print();
                        break;
                    case";":
                        comments();
                        break;
                    case "cond":
                        cond();
                        break;
                    case "defun":
                        defun();
                        break;
                    default:
                        //callfunction(token);
                        int x=0;
                        while(x<token.length()-1){
                            stackToken.pop();
                            x++;
                        }
                        String param= "";
                        while(!stackToken.peek().equals(")")){
                            if(param.equals("")){
                                param= stackToken.pop();
                            }else{
                                param= param+" "+stackToken.pop();
                            }
                        }
                        callfunction(token, param);
                        break;
                }
            }else{
                String patternAtom = "[\\d\\+\\-]?[\\d]*";

                if(!token.equals(")")){
                    throw new Exception("NO COMIENZA CON PARENTESIS");
                }else if(token.matches(patternAtom)){
                    atom();
                }
                
                
            }
        
        }
            
    }


    public void print(){
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
                        
    }

    public void comments(){
        boolean foundNewLine = false;
        while(!stackToken.empty()){
            actualName = stackToken.pop();
            if (actualName == ("/n")){
                foundNewLine = true;
                break;
            }
        }
    }


    public void atom(){
        String input = token;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public void cond() throws Exception{
        int countCond= 2;
        stackToken.pop();
        stackToken.pop();
        stackToken.pop();
        boolean flag= false;
        while(!flag){
            
            if(!stackToken.peek().equals("(")){
                throw new Exception("NO COMIENZA CON PARENTESIS EL CONDICIONAL");
            }
            stackToken.pop();
            stackToken.pop();
            String symbol = stackToken.pop();
            switch (symbol) {
                case ">":
                    try{
                        double item1 = Double.parseDouble(stackToken.pop());
                        double item2 = Double.parseDouble(stackToken.pop());
                        if(item1>item2){
                            stackToken.pop();
                            if(stackToken.peek().equals("\"")){
                                stackToken.pop();
                                String value = stackToken.pop();
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
                                    
                                System.out.println("value "+value);
                                flag=true;
                                
                                while(countCond!=2){
                                    String search = stackToken.pop();
                                    if(search.equals(")")){
                                        countCond++;
                                    }else{
                                        countCond=0;
                                    }
                                }
                            }else{
                                validateCharacter();
                            }
                            
                        }else{
                            int countParenthesit=0;
                            while(countParenthesit!=2){
                                if(stackToken.pop().equals(")")){
                                    countParenthesit++;
                                }

                                
                            }
                            if(stackToken.peek().equals(")")){
                                //finish
                                flag=true;
                            }
                        }
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                        throw new Exception("NOT A NUMBER");
                    }
                    break;
                case "<":
                    try{
                        double item1 = Double.parseDouble(stackToken.pop());
                        double item2 = Double.parseDouble(stackToken.pop());
                        if(item1<item2){
                            stackToken.pop();
                            if(stackToken.peek().equals("\"")){
                                stackToken.pop();
                                String value = stackToken.pop();
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

                                System.out.println("value "+value);
                            }
                            validateCharacter();
                            flag=true;
                        }else{
                            int countParenthesit=0;
                            while(countParenthesit!=2){
                                if(stackToken.pop().equals(")")){
                                    countParenthesit++;
                                }
                            }
                        }
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                        throw new Exception("NOT A NUMBER");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void add() throws Exception{
        String value1 = stackToken.pop();
        String value2 = stackToken.pop();
        try{
            double item1 = Double.parseDouble(value1);
            double item2 = Double.parseDouble(value2);
            double result = calculator.add(item1, item2);
            if(!actualName.equals("")){
                doubleVariables.add(actualName,result);
                actualName = "";
            }
            System.out.println(result);
        }catch(NumberFormatException e){
            if(doubleVariables.getValue(value1)!=null){
                double item1 = doubleVariables.getValue(value1);
                double item2 = doubleVariables.getValue(value2);
                double result = calculator.add(item1, item2);
                System.out.println(result);
            }else{
                e.printStackTrace();
                throw new Exception("NOT A NUMBER");
            }
           
        }
    }

    public void substract() throws Exception{
        String value1 = stackToken.pop();
        String value2 = stackToken.pop();
        try{
            double item1 = Double.parseDouble(value1);
            double item2 = Double.parseDouble(value2);
            double result = calculator.subtraction(item1, item2);
            if(!actualName.equals("")){
                doubleVariables.add(actualName, result);
                actualName = "";
            }
            System.out.println(result);

        }catch(NumberFormatException e){
            if(doubleVariables.getValue(value1)!=null){
                double item1 = doubleVariables.getValue(value1);
                double item2 = doubleVariables.getValue(value2);
                double result = calculator.subtraction(item1, item2);
               
                System.out.println(result);
            }else{
                e.printStackTrace();
                throw new Exception("NOT A NUMBER");
            }
        } 
    }

    public void divide() throws Exception{
        String value1 = stackToken.pop();
        String value2 = stackToken.pop();
        try{
            double item1 = Double.parseDouble(value1);
            double item2 = Double.parseDouble(value2);
            double result = calculator.division(item1, item2);
            if(!actualName.equals("")){
                doubleVariables.add(actualName,result);
                actualName = "";
            }
            System.out.println(result);
        }catch(NumberFormatException e){
            if(doubleVariables.getValue(value1)!=null){
                double item1 = doubleVariables.getValue(value1);
                double item2 = doubleVariables.getValue(value2);
                double result = calculator.division(item1, item2);
                System.out.println(result);
            }else{
                e.printStackTrace();
                throw new Exception("NOT A NUMBER");
            }
        }
    }

    public void multiply() throws Exception{
        String value1 = stackToken.pop();
        String value2 = stackToken.pop();
        try{
            double item1 = Double.parseDouble(value1);
            double item2 = Double.parseDouble(value2);
            double result = calculator.multiplication(item1, item2);
            if(!actualName.equals("")){
                doubleVariables.add(actualName,result);
                actualName = "";
            }
            System.out.println(result);

        }catch(NumberFormatException e){
            if(doubleVariables.getValue(value1)!=null){
                double item1 = doubleVariables.getValue(value1);
                double item2 = doubleVariables.getValue(value2);
                double result = calculator.multiplication(item1, item2);
                System.out.println(result);
            }else{
                e.printStackTrace();
                throw new Exception("NOT A NUMBER");
            }
        }
    }

    public void setq(){
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
    }

    public void defun() throws Exception{
        stackToken.pop();
        stackToken.pop();
        stackToken.pop();
        stackToken.pop();
        String patternLettersNumbers = "[a-zA-Z0-9]+";
        String name = stackToken.pop();
        if(!name.matches(patternLettersNumbers)){
            throw new Exception("THE FUNCTION REQUIRE A NAME");
        }

        int x=0;
        while(x<name.length()-1){
            stackToken.pop();
            x++;
        }
        if(!stackToken.peek().equals("(")){
            throw new Exception("THE FUNCTION REQUIRE ()");
        }

        stackToken.pop();
        x=0;
        String function ="";
        while(x!=2){
            String temp = stackToken.pop();
            if(temp.equals(")")){
                x++;
            }else{
                if(function.equals("")){
                    function =temp;
                }else{
                    function = function+" "+temp;
                }
                x=0;
            }
        }
        function = function+"))";
        defunVariables.add(name, function);
    }


    public void callfunction(String name, String params) throws Exception{
        if(stackToken.peek().equals(")")){
            stackToken.pop();
        }

    
        Stack<String> stackTokenfunction = new Stack<String>();
        if(defunVariables.getValue(name)==null){
            throw new Exception("name defun invalid");
        }

        String function = defunVariables.getValue(name);

        stackTokenfunction = keyWords.separateWithPairs(function);


        
       



        if(token.equals("(")){
            //no tiene params
            stackToken.push("(");
        }else if(params.length()>0){
            String[] paramsArray = params.split(" ");
            for (String string : paramsArray) {
                String token = stackTokenfunction.pop();
                try{
                    double item = Double.parseDouble(string);
                    doubleVariables.add(token,item);
                } catch (NumberFormatException e) {
                    // string
                    stringVariables.add(token,string);
                }
            }
        }
        
        while(stackTokenfunction.size()!=1){
            String tokenValue = stackTokenfunction.pop();
            stackToken.push(tokenValue);
        }
        // int x=0;
        // while(x != stackToken.size()){
        //     System.out.println("PRINT 2: "+ stackToken.getvalue(x));
        //     x++;
        // }
        
    }
}
