package assignments.ten;

import java.util.ArrayList;

public class FindAllIndices {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,9};
        int n = 10, curr = 0;
        System.out.println("Element " + n + " found at indices: " + linearSearch(arr, curr, n));
    }

    //Since we are not passing the list as a parameter, each recursive call create a new list, so to
    //combine the results we need to combine the list of the below calls to the current one before returning.
    public static ArrayList<Integer> linearSearch(int[] arr, int curr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (curr == arr.length) {
            return list;
        }
        if (arr[curr] == n) {
            list.add(curr);
        }
        ArrayList<Integer> belowCalls = linearSearch(arr, ++curr, n);
        list.addAll(belowCalls);
        return list;
    }
}
