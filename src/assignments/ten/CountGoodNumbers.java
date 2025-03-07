package assignments.ten;

//A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
//Input: n = 1
//Output: 5
//Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
public class CountGoodNumbers {
    private static final int MOD_BY = 1000000007;

    public static void main(String[] args) {
        CountGoodNumbers countGoodNumbers = new CountGoodNumbers();
        System.out.println(countGoodNumbers.countGoodNumbers(6));
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        // Compute the total good numbers as (5^evenCount * 4^oddCount) % MOD_BY
        long evenChoices = power(5, evenCount);
        long oddChoices = power(4, oddCount);

        return (int) ((evenChoices * oddChoices) % MOD_BY);
    }

    public long power(int base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2);
        long res = (half * half) % MOD_BY;

        if (exp % 2 == 1) {
            res = (res * base) % MOD_BY;
        }
        return res;
    }
}
