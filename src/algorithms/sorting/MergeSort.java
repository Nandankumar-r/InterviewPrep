package algorithms.sorting;

import java.util.Arrays;


//Time: O(NlogN)
//Space: O(N)
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,7,56,7,5,9,0};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res[k++] = left[i];
                i++;
            } else {
                res[k++] = right[j];
                j++;
            }
        }
        while (i < left.length) {
            res[k++] = left[i];
            i++;
        }
        while (j < right.length) {
            res[k++] = right[j];
            j++;
        }
        return res;
    }
}
