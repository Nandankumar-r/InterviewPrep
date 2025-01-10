package algorithms.sorting;

import java.util.Arrays;

//Space complexity: O(1) (hence called in place algorithm)
//Time complexity:
//Best case - O(n^2)
//Worst case - O(n^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,0,-1};
        selectionSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int last = arr.length - i - 1;
            //find the maximum number's index in the array and swap it to it's correct position
            int maxIndex = findMax(0, last, arr);
            int temp = arr[last];
            arr[last] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    private static int findMax(int start, int end, int[] arr) {
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
