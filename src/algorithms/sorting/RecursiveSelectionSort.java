package algorithms.sorting;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

public class RecursiveSelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,6,5,-1};
        selectionSort(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    // Recursive function for selection sort in increasing order
    // Parameters:
    // arr: The array to be sorted
    // n: The total number of elements in the array (used for determining the unsorted portion)
    // i: The current index to process in the unsorted portion of the array
    public static void selectionSort(int[] arr, int n, int i) {
        // We have reached the last element, no more sorting is needed
        if (i == arr.length - 1) {
            return;
        }

        // Find the index of the minimum element in the unsorted portion of the array (from i to n-1)
        // i keeps incrementing because till 0 to i is already sorted and end remains same as n - 1
        int min = findMin(arr, i, n - 1);

        // If the minimum element is not already at index i, swap it with the element at i
        if (min != i) {
            swap(arr, min, i);
        }

        // Recursive call: Move to the next element in the unsorted portion by incrementing i
        selectionSort(arr, n, i + 1);
    }

    // Helper function to find the index of the minimum element between indices i and j in the array
    // arr: The array being sorted
    // i: The start index for the unsorted portion
    // j: The end index for the unsorted portion
    public static int findMin(int[] arr, int i, int j) {
        // Base case: If only one element is left (i == j), it's the minimum
        if (i == j) {
            return i;
        }

        // Recursively find the minimum element in the remaining unsorted portion (i + 1 to j)
        int k = findMin(arr, i + 1, j);

        // Compare the current element arr[i] with the element found in the recursive call (arr[k])
        // Return the index of the smaller element
        return arr[i] < arr[k] ? i : k;
    }
}
