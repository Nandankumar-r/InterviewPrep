package assignments.two;

import java.util.Scanner;

public class EvenOrNot {
    public static void main(String[] args) {
        System.out.print("Please enter a number ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() % 2 ==0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
