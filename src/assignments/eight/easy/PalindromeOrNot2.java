package assignments.eight.easy;

//https://leetcode.com/problems/valid-palindrome-ii/description/
public class PalindromeOrNot2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return (isValidPalindrome(s, start + 1, end) || isValidPalindrome(s, start, end - 1));

            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isValidPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
