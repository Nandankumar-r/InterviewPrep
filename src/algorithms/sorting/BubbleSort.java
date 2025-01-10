package algorithms.sorting;

import java.util.Arrays;

//Space complexity: O(1) (hence called in place algorithm)
//Time complexity:
    //Best case - O(n) (sorted array)
    //Worst case - O(n^2) (reverse sorted array)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,465,123,442,566,3,-1};
        bubbleSortIncreasing(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSortDecreasing(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortDecreasing(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                int temp = arr[j-1];
                if (arr[j] > arr[j-1]) {
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("Array is already sorted");
                break;
            }
        }
    }

    public static void bubbleSortIncreasing(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            //j -> 1 to len - i because for every iteration of i the largest element goes to the correct index (right most available index)
            for (int j = 1; j < arr.length - i; j++) {
                int temp = arr[j-1];
                if (arr[j] < arr[j-1]) {
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("Array is already sorted");
                break;
            }
        }
    }
}
