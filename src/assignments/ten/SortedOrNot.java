package assignments.ten;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,9,0};
        System.out.println(isSorted(arr, 0));
    }

    private static boolean isSorted(int[] arr, int curr) {
        if (curr == arr.length - 1) {
            return true;
        }
        if (arr[curr] > arr[curr + 1]) {
            return false;
        } else {
            return isSorted(arr, ++curr);
        }
    }
}
