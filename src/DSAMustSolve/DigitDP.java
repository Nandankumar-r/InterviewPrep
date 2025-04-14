package DSAMustSolve;

import java.util.HashMap;
import java.util.Map;

class DigitDP {
    private String[] digits;
    private String numStr;
    private Map<String, Long> memo;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        this.numStr = String.valueOf(n);
        this.memo = new HashMap<>();
        int total = 0;
        // count all numbers with fewer digits than n
        for (int len = 1; len < numStr.length(); len++) {
            total += Math.pow(digits.length, len);
        }
        // add valid numbers with same number of digits as n
        total += dfs(0, true, true);
        return total;
    }


    private long dfs(int pos, boolean tight, boolean leadingZero) {
        // ✅ Base Case
        if (pos == numStr.length()) {
            return leadingZero ? 0 : 1;  // valid number only if we placed something
        }

        // ✅ Memo key
        String key = pos + "|" + (tight ? 1 : 0) + "|" + (leadingZero ? 1 : 0);
        if (memo.containsKey(key)) return memo.get(key);

        long total = 0;

        int limit = tight ? numStr.charAt(pos) - '0' : 9;

        for (String dStr : digits) {
            int d = dStr.charAt(0) - '0';

            if (d > limit) continue;  // violates tight constraint

            boolean nextTight = tight && (d == limit);
            boolean nextLeadingZero = leadingZero && (d == 0);

            total += dfs(pos + 1, nextTight, false);  // we placed a digit, so leadingZero is now false
        }

        // Also consider skipping placing a digit here (continue leading zeros if allowed)
        if (leadingZero) {
            total += dfs(pos + 1, tight, true);  // don't place any digit here
        }

        memo.put(key, total);
        return total;
    }

    public static void main(String[] args) {
        DigitDP obj = new DigitDP();
        String[] digits = {"1", "3", "5", "7"};
        int n = 20;
        System.out.println(obj.atMostNGivenDigitSet(digits, n));
    }
}

