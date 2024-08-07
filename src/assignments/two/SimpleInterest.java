package assignments.two;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        System.out.print("Enter the principal amount ");
        Scanner scanner = new Scanner(System.in);
        float principal = scanner.nextFloat();
        System.out.print("Enter the time ");
        float time = scanner.nextFloat();
        System.out.print("Enter the rate of interest ");
        float rate = scanner.nextFloat();
        float simpleInterest = (principal * time * rate)  / 100;
        System.out.println("Simple Interest is " + simpleInterest);
    }
}
