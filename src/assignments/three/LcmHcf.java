package assignments.three;

import java.util.Scanner;

public class LcmHcf {
    public static void main(String[] args) {
        System.out.print("Enter 2 numbers for which lcm & hcf is needed ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int hcf = hcf(a, b);
        System.out.println("HCF is " + hcf);
        int lcm = (a * b)/hcf;
        System.out.println("LCM is " + lcm);
    }
    public static int hcf(int a, int b) {
        if (a == 0)
            return b;
        return hcf(b % a, a);
    }
}
