package algorithms.sorting;

//When the range of elements in the given array is between 1 - N,
// with all the numbers till N appearing in the array, always use cyclic sort algorithm.

import java.util.Arrays;

//Time complexity - O(N) best & worst case
//Space complexity - O(1) In place algorithm
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,7,1,3,6,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
    }
}
