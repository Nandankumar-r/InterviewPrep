package assignments.eight.medium;

//https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/
public class CheckIfPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("ulacfd", "jibblu"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public static boolean check(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < j; ++i, --j)
            if (a.charAt(i) != b.charAt(j))
                return isPa(a, i, j) || isPa(b, i, j);
        return true;
    }

    public static boolean isPa(String s, int i, int j) {
        for (; i < j; ++i, --j) // ; in initialization means that my iterator i & j are initialised outside this loop
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
