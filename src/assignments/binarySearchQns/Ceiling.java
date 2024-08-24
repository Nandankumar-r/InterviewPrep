package assignments.binarySearchQns;

public class Ceiling {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5, 7, 9, 63, 69};
        int res = ceil(arr, 6);
        System.out.println(res);
    }

    public static int ceil (int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == num) {
                return arr[mid];
            } else if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start > arr.length - 1)
            return -1;
        return arr[start];
        // To return the ceiling
        /*
        if (end < 0)
            return -1;
        return arr[end];
         */
    }
}
