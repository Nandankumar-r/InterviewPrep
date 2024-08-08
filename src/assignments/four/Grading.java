package assignments.four;

import java.util.Scanner;

public class Grading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the marks ");
        int marks = scanner.nextInt();
        if (marks >=91 && marks<=100) {
            System.out.println("AA");
        } else if (marks>=81 && marks<=90) {
            System.out.println("BB");
        }

    }
}
