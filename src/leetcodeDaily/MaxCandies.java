package leetcodeDaily;

import java.util.Arrays;

public class MaxCandies {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;
        System.out.println(maximumCandies(candies, k));
    }
    public static int maximumCandies(int[] candies, long k) {
        long totalCandies = Arrays.stream(candies).asLongStream().sum(); // Avoid overflow
        if (totalCandies < k) {
            return 0;
        }
        int l = 1, r = (int)(totalCandies / k);
        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long count = 0;
            for (int candy : candies) {
                if (candy >= m) {
                    count += candy / m;
                }
                if (count >= k)
                    break;
            }
            if (count >= k) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
