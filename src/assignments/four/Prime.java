package assignments.four;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the range ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            boolean prime = isPrime(i);
            if (prime)
                System.out.print(i + " ");
        }
    }

    static boolean isPrime(int num) {
        if (num == 1)
            return true;
        if (num == 0)
            return false;
        int c = 2;
        while (c*c <= num) {
            if (num % c == 0) {
                return false;
            } else {
                c++;
            }
        }
        return true;
    }
}
