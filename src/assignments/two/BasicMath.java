package assignments.two;

import java.util.Objects;
import java.util.Scanner;

public class BasicMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number ");
        float firstNumber = scanner.nextFloat();
        System.out.print("Enter the second number ");
        float secondNumber = scanner.nextFloat();
        System.out.print("Enter the operator ");
        String operator = scanner.next();
        if (Objects.equals(operator, "+")) {
            System.out.print("Addition performed " + (firstNumber + secondNumber));
        } else if (Objects.equals(operator, "-")) {
            System.out.print("Subtraction performed " + (firstNumber - secondNumber));
        } else if (Objects.equals(operator, "/")) {
            System.out.print("Division performed " + (firstNumber / secondNumber));
        } else if (Objects.equals(operator, "*")) {
            System.out.print("Multiply performed " + (firstNumber * secondNumber));
        } else {
            System.out.print("Unknown operator please enter +, -, * or /");
        }
    }
}
