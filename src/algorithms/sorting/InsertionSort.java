package algorithms.sorting;

import java.util.Arrays;

//Space complexity: O(1) (hence called in place algorithm)
//Time complexity:
//Best case - O(n) (sorted array)
//Worst case - O(n^2) (reverse sorted array)
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, -1, 8, 7, -5};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //You keep inserting the next index element to your search space hence it's called insertion sort
            //j decrements because we need to check all the elements before it to find it's correct index
            for (int j = i+1; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

}
