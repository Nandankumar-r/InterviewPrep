package algorithms.sorting;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

//Time O(n*n)
//Space O(n)
public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        bubbleSort(arr, arr.length, 0, false);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int n, int j, boolean swapped) {
        // Base case: If the array size is 1, return
        if (n == 1) {
            return;
        }
        // If the inner loop is completed, check if any swaps occurred
        if (j == n - 1) {
            // If no swaps occurred during this pass, the array is already sorted
            if (!swapped) {
                return;
            }
            // Start the next pass with the size reduced by 1
            bubbleSort(arr, n - 1, 0, false);
            return; // is needed to avoid executing below lines once the function call returns to the above line
        }

        if (arr[j] > arr[j + 1]) {
            swap(arr, j, j + 1);
            swapped = true;
        }
        // Move to the next pair in the current pass
        bubbleSort(arr, n, j + 1, swapped);
    }


}
