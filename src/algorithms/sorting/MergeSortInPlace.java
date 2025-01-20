package algorithms.sorting;

import java.util.Arrays;

//Time: O(NlogN)
//Space: O(logN)
public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,7,56,7,5,9,0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeInplace(arr, start, mid, end);
    }

    private static void mergeInplace(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                //element in the right half is smaller
                //hence shift all the elements from i to j-1 after arr[j]
                int temp = arr[j];
                int k = j;
                while (k > i) {
                    arr[k] = arr[k - 1];
                    k--;
                }
                arr[i] = temp;

                i++;
                //When an element from the right half is inserted into the left half,
                //the midpoint mid must shift right to account for the extra element now included in the left half
                mid++;
                j++;
            }
        }
    }
}
