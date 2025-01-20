package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the left and right subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose the middle element as the pivot
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        while (low <= high) {
            // Find elements on the wrong side of the pivot
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }

            // Swap elements if needed and move pointers
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
