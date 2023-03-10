import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la operación en formato prefix ");

        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        Stack<Double> stack = new Stack<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double resultado = 0;
                switch (token) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        resultado = num1 / num2;
                        break;
                    default:
                        System.out.println("Operador inválido., vuelava a ingresar el dato");
                        return;
                }
                stack.push(resultado);
            }
        }

        System.out.println("El resultado es: " + stack.pop());
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
