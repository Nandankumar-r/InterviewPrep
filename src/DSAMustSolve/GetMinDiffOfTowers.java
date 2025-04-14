package DSAMustSolve;

import java.util.Arrays;

public class GetMinDiffOfTowers {
    public static void main(String[] args) {
        int k = 7;
        int[] arr = new int[] {1, 8, 10, 6, 4, 6, 9, 1};
        System.out.println(getMinDiff(arr, k));
    }
    public static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        int min, max;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(smallest, arr[i + 1] - k);
            max = Math.max(largest, arr[i] + k);
            if (min < 0) continue;
            res = Math.min(res, max - min);
        }
        return res;
    }
}
