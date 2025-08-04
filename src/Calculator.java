import java.util.Scanner;

public class Calculator {
    public static double addition(double x, double y){
        return x+y;
    }
    public static double subtraction(double x, double y){

        return x-y;
    }
    public static double multiplication(double x, double y){

        return x*y;
    }
    public static double division(double x, double y){
        if(y == 0){
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return x/y;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("CALCULATOR");
                System.out.print("Enter the first number: ");
                double num1 = input.nextDouble();
                System.out.print("Enter the second number: ");
                double num2 = input.nextDouble();
                System.out.print("Enter the operation (+,-,/,*): ");
                char operation = input.next().charAt(0);

                double result = 0;
                boolean isResultCorrect = true;

                switch (operation) {
                    case '+':
                        result = addition(num1, num2);
                        break;
                    case '-':
                        result = subtraction(num1, num2);
                        break;
                    case '*':
                        result = multiplication(num1, num2);
                        break;
                    case '/':
                        try {
                            result = division(num1, num2);
                        } catch (ArithmeticException e) {
                            System.out.println("Error occurred: " + e.getMessage());
                            isResultCorrect = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid operation");
                        isResultCorrect= false;
                }

                if (isResultCorrect) {
                    System.out.println("Result: " + result);
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
                input.nextLine();
            }


            System.out.println("Do you want to perform another operation? (y/n): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                System.out.println("Calculator closed!");
                break;
            }
        }


        input.close();
    }
}