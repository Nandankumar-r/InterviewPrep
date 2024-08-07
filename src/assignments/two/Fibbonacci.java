package assignments.two;

import java.util.Scanner;

public class Fibbonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number ");
        int number = scanner.nextInt();
        int currNum = 1;
        int prevNum = 0;
        if (number < 0) {
            System.out.println("No fibbonacci series for numbers <= 0");
        } else {
            System.out.print("Fibonacci series upto " + number + " is " + 0 + " " + 1 + " ");
            while ((currNum + prevNum) <= number) {
                int temp = currNum + prevNum;
                prevNum = currNum;
                currNum = temp;
                System.out.print(temp + " ");
            }
        }
    }
}
