package assignments.three;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for which factorial is required ");
        int num = scanner.nextInt();
        int factorial = 1;
        while (num > 0) {
            factorial *= num;
            num--;
        }
        System.out.println(factorial);
    }
}
