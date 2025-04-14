package leetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeInRange {
    public static void main(String[] args) {
        ClosestPrimeInRange range = new ClosestPrimeInRange();
        System.out.println(Arrays.toString(range.closestPrimes(10, 19)));
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primesInRange = getPrimes(left, right);
        if (primesInRange.size() < 2) {
            return new int[]{-1, -1};
        }

        int[] res = {-1, -1}; // Store the closest prime pair
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < primesInRange.size(); i++) {
            int diff = primesInRange.get(i) - primesInRange.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                res[0] = primesInRange.get(i - 1);
                res[1] = primesInRange.get(i);
            }
        }
        return res;
    }

    private List<Integer> getPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) { // Start from max(2, left)
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
