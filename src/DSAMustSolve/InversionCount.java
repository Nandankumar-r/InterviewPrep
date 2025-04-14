package DSAMustSolve;

public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3};
        System.out.println(inversionCount(arr));
    }

    public static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) / 2);
        int count = 0;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1,  k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j] → all remaining elements in left part (from i to mid) will also be greater
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return count;
    }

}
