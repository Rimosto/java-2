
import java.util.Scanner;

class operator
{
    public static void main(String[] args) {
        {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Enter the first number:");
                   int  num1 = scanner.nextInt();

                    System.out.println("Enter the second number:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Enter the operator (+, -, *, /,%):");
                    char op = scanner.next().charAt(0);
                    double result = 0;

                    switch (op)        
                     {
                        case '+':
                            result = num1 + num2;
                            System.out.println("Result: " + result);
                            break;
                        case '-':
                            result = num1 - num2;
                            System.out.println("Result: " + result);
                            break;
                        case '*':
                            result = num1 * num2;
                            System.out.println("Result: " + result);
                            break;
                        case '/':
                            if (num2 != 0)
                            {
                                result = num1 / num2;
                                System.out.println("Result: " + result);
                            }
                            else
                            {
                                System.out.println("Error: Division by zero!");
                            }
                            break;
                            case '%':
                            if (num2 != 0) {
                                result = num1 %  num2;
                                System.out.println("Result: " + result);
                            } else {
                                System.out.println("Error: Division by zero!");
                            }
                            break;
                          
                        default:
                            System.out.println("Invalid operator!");
                            break;
                    }
                }
    }
}
}