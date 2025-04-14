package DSAMustSolve;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

public class RotateArrayByOne {
    public static void main(String[] args) {
        // 1st approach (Risky)
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, i, (i + 1) % n);
        }
        System.out.println(Arrays.toString(arr));

        // 2nd approach
        arr = new int[]{1, 2, 3, 4, 5};
        int last = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            swap(arr, i, i + 1);
        }
        arr[0] = last;
        System.out.println(Arrays.toString(arr));
    }
}
