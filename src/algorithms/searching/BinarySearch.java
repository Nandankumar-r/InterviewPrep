package algorithms.searching;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter a sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = binarySearch(arr, 4);
        System.out.println(res);
    }

    public static int binarySearch (int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        boolean isAsc = arr[0] < arr[arr.length - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2; // always calculate mid like this to avoid start+end exceeding the int limit
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
