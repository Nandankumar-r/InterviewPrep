package assignments.two;

import java.util.Scanner;

public class GreatestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number ");
        float firstNumber = scanner.nextFloat();
        System.out.print("Enter the second number ");
        float secondNumber = scanner.nextFloat();
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " > " + secondNumber);
        } else {
            System.out.println(secondNumber + " > " + firstNumber);
        }
    }
}
