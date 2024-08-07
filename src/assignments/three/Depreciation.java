package assignments.three;

import java.util.Scanner;

public class Depreciation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount ");
        float amount = scanner.nextInt();
        System.out.print("Enter rate ");
        float rate = scanner.nextInt();
        System.out.print("Enter time ");
        float time = scanner.nextInt();

        //amount*((1-(rate/100))**t)
        double depreciatedValue = amount*(Math.pow((1-rate/100), time));
        System.out.println(depreciatedValue);
    }
}
