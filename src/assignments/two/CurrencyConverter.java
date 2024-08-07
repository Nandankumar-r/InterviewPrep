package assignments.two;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in INR ");
        float inrAmount = scanner.nextFloat();
        System.out.println("Amount in dollors is " + (inrAmount * 0.012));
    }
}
