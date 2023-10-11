import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        System.out.print("Введите арифметическую операцию н.р. 1+1: ");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        check(operation);
        calculator(operation);
    }

    public static String operator(String operation) {
        String matOperator = "";
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+') {
                matOperator = "+";
            }
            if ((operation.charAt(i) == '-')) {
                matOperator = "-";
            }
            if ((operation.charAt(i) == '*')) {
                matOperator = "*";
            }
            if ((operation.charAt(i) == '/'))
                matOperator = "/";
        }
        return matOperator;
    }

    public static void check(String operation) {
        Pattern pattern = Pattern.compile("^\\d+[-+*/%]\\d+");
        Matcher matcher = pattern.matcher(operation);
        if (!matcher.matches()) {
            throw new IncorrectMathematicalOperationFormat();
        }
    }

    public static void calculator(String operation) {
        int operand1 = Integer.valueOf(operation.substring(0, operation.lastIndexOf(operator(operation))));
        int operand2 = Integer.valueOf(operation.substring(operation.lastIndexOf(operator(operation)) + 1, operation.length()));
        if (operand1>10||operand2>10){
            throw new IncorrectMathematicalOperationFormat();
        }
        switch (operator(operation)) {
            case "+":
                System.out.println(operand1 + operand2);
                break;
            case "-":
                System.out.println(operand1 - operand2);
                break;
            case "*":
                System.out.println(operand1 * operand2);
                break;
            case "/":
                System.out.println(operand1 / operand2);
                break;
        }
    }
}