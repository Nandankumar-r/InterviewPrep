package leetcodeDaily;

import java.util.Arrays;

public class MarblesInBag {
    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        int[] pairs = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            pairs[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairs);

        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += pairs[i];  // Smallest (k-1) elements for min sum
            max += pairs[pairs.length - 1 - i];  // Largest (k-1) elements for max sum
        }
        return max - min;
    }
}
