package algorithms.searching;

public class RecursiveBinaryRotatedSearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        int n = 7;
        System.out.println(binaryRotatedSearch(arr, n, 0, arr.length - 1));
    }

    private static int binaryRotatedSearch(int[] arr, int n, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= n && arr[mid] >= n) {
                return binaryRotatedSearch(arr, n, start, mid-1);
            } else {
                return binaryRotatedSearch(arr, n, mid+1, end);
            }
        } else {
            if (arr[mid] <= n && arr[end] >= n) {
                return binaryRotatedSearch(arr, n, mid+1, end);
            } else {
                return binaryRotatedSearch(arr, n, start, mid-1);
            }
        }
    }

}
