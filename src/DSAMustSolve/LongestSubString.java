package DSAMustSolve;

public class LongestSubString {
    private String res = "";
    private int longest = 0;
    public String longestPalindrome(String s) {
        //try everything as mid
        //get left and right chars nect to mid
        //check for equal and repeat
        for (int i = 0; i < s.length(); i++) {
            // Odd-length center: expand around i
            expandAroundCenter(s, i, i);

            // Even-length center: expand around i and i + 1
            expandAroundCenter(s, i, i + 1);
        }
        return res;
    }

    public void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (res.length() < right - left + 1) {
                res = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
}
