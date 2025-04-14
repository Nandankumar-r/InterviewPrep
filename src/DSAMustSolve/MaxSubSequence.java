package DSAMustSolve;

public class MaxSubSequence {
    public static void main(String[] args) {
        String text1 = "abcdefg";
        String text2 = "gfedcba";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int i = 0, j = 0;
        int count = 0;
        while (i < text1.length() && j < text2.length()) {
            if (text1.charAt(i) == text2.charAt(j)) {
                count++;
                i++;
                j++;
            } else {
                int l1 = text1.length() - i;
                int l2 = text2.length() - j;
                if (l1 < l2)
                    j++;
                else
                    i++;
            }
        }
        return count;
    }
    public int longestCommonSubsequenceDP(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
