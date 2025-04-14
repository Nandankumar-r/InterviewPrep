package DSAMustSolve;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 2];
        dp[n] = 1; dp[n + 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i + 1];
            }
            if (i + 1 < n && isValidTwoDigit(s.substring(i, i+2))) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public boolean isValidTwoDigit(String sub) {
        int val = Integer.parseInt(sub);
        return val >= 10 && val <= 26;
    }
}
