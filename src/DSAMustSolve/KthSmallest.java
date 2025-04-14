package DSAMustSolve;

import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int result = kthSmallest(arr, k);
        System.out.println("Kth Smallest Element: " + result);
    }

    public static int kthSmallest(int[] arr, int k) {
        // Step 1: Find the maximum element
        int maxElement = Arrays.stream(arr).max().getAsInt();

        // Step 2: Create frequency array
        int[] count = new int[maxElement + 1];

        // Step 3: Fill frequency array
        for (int num : arr) {
            count[num]++;
        }

        // Step 4: Find the Kth smallest element
        int countSum = 0;
        for (int i = 0; i <= maxElement; i++) {
            countSum += count[i];
            if (countSum >= k) {
                return i; // The Kth smallest element
            }
        }

        return -1; // Should never reach here
    }

}
