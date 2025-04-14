package leetcodeDaily;

class PowerfulInt {
    private Long[][] dp; // dp[idx][tight]
    private String suffix;
    private int limit;

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        this.limit = limit;
        this.suffix = suffix;

        // Inclusion-Exclusion trick: count up to finish, subtract those below start
        long countToFinish = countValid(finish);
        long countToStart = countValid(start - 1);
        return countToFinish - countToStart;
    }

    private long countValid(long num) {
        // Optimization: if 'num' is smaller than the suffix, it can't possibly be valid
        if (num < Long.parseLong(suffix)) return 0;

        String numStr = Long.toString(num);
        dp = new Long[numStr.length()][2]; // Reset DP for this number length

        // Start digit DP from position 0
        return dfs(0, true, numStr);
    }

    /**
     * Digit DP recursive function
     *
     * @param idx   Current digit position we are building
     * @param tight Whether we are still constrained by the upper bound (numStr)
     * @param num   The upper bound number as string
     */
    private long dfs(int idx, boolean tight, String num) {
        // Base case: fully built a number
        if (idx == num.length()) return 1L;

        // Memoization lookup
        if (dp[idx][tight ? 1 : 0] != null) return dp[idx][tight ? 1 : 0];

        long res = 0;
        int maxDigit = tight ? num.charAt(idx) - '0' : 9;

        // Calculate where suffix starts in the number
        int suffixStart = num.length() - suffix.length();

        if (idx >= suffixStart) {
            // We're inside the suffix zone now → must match digits exactly
            int suffixIdx = idx - suffixStart;
            int digit = suffix.charAt(suffixIdx) - '0';

            // Check if digit is within allowed bounds
            if (digit <= maxDigit && digit <= limit) {
                boolean nextTight = tight && (digit == maxDigit);
                res += dfs(idx + 1, nextTight, num);
            }
        } else {
            // Not in suffix zone yet → free to choose any digit ≤ limit
            for (int d = 0; d <= Math.min(maxDigit, limit); d++) {
                boolean nextTight = tight && (d == maxDigit);
                res += dfs(idx + 1, nextTight, num);
            }
        }

        // Memoize and return
        dp[idx][tight ? 1 : 0] = res;
        return res;
    }
}

