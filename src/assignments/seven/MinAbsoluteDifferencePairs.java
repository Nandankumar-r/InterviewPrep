package assignments.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-absolute-difference/description/
public class MinAbsoluteDifferencePairs {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDiffer = Integer.MAX_VALUE;

        //start looping over array to find real min element. Each time we find smaller difference,
        //we reset resulting list and start building it from scratch. If we find a pair with the same
        //difference as min - add it to the resulting list
        for (int i = 0; i < arr.length - 1; i++) {
            int differ = arr[i + 1] - arr[i];
            if (differ < minDiffer) {
                minDiffer = differ;
                result.clear();
            }
            if (differ == minDiffer) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}
