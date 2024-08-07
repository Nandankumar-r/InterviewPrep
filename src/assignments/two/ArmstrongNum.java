package assignments.two;

import java.util.Scanner;

public class ArmstrongNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first Number ");
        int firstNum = scanner.nextInt();
        System.out.println("Please enter second Number ");
        int secondNum = scanner.nextInt();
        if (firstNum > secondNum) {
            int temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }
        while(firstNum < secondNum) {
            int rem, tempArm = 0;
            int temp = firstNum;
            while (temp > 0) {
                rem = temp % 10;
                temp = temp / 10;
                tempArm += rem*rem*rem;
            }
            if (tempArm == firstNum) {
                System.out.println("Amstrong number found " + tempArm);
            }
            firstNum++;
        }
    }
}
