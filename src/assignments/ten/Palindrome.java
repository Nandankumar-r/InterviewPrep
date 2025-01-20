package assignments.ten;

//Time: O(n)
//Space: O(n)
public class Palindrome {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }
    public static boolean isPalindrome(String s, int start, int end) {
        if (end < 1) {
            return true;
        }
        if (start <= end) {
            return s.charAt(start) == s.charAt(end);
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        } else {
            return isPalindrome(s, ++start, --end);
        }
    }
}
