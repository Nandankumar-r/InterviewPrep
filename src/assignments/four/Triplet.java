package assignments.four;

import java.util.Scanner;

public class Triplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the triplet: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if ((a*a) == ((b*b) + (c*c)) || (b*b) == ((a*a) + (c*c)) || (c*c) == ((b*b) + (a*a))) {
            System.out.println("Pythogorean triplets");
        } else {
            System.out.println("Not a pythogorean triplet");
        }
    }
}
