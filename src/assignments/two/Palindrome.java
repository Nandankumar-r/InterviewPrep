package assignments.two;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a String ");
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = false;
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
                isPalindrome = true;
            } else {
                isPalindrome = false;
                System.out.println("Not a palindrome");
                break;
            }
        }
        if (isPalindrome)
            System.out.println("Palindrome");
    }
}
