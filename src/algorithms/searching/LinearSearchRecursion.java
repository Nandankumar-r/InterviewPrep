package algorithms.searching;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,9};
        int n = 9, curr = 0;
        System.out.println("Element " + n + " found at index: " + linearSearch(arr, curr, n));
    }
    public static int linearSearch(int[] arr, int curr, int n) {
        if (arr[curr] == n) {
            return curr;
        } else if (curr == arr.length - 1) {
            return -1;
        } else {
            return linearSearch(arr, ++curr, n);
        }
    }
}
