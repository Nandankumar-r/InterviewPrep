package DSAMustSolve;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PairSumZero {
    public static void main(String[] args) {
        int[] arr = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5, 0 , 0, 0, 0};
        System.out.println(getPairs(arr));
    }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // Step 1: Track seen elements
        Set<Integer> seen = new HashSet<>();
        // Step 2: Use a set to store unique sorted pairs (as strings or Lists)
        Set<ArrayList<Integer>> pairSet = new HashSet<>();
        int countZero = 0;

        // Step 3: Iterate through arr
        for (int num : arr) {
            if (seen.contains(-num)) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(Math.min(num, -num));
                pair.add(Math.max(num, -num));
                pairSet.add(pair);
            }
            seen.add(num);
            if (num == 0) countZero++;
        }

        // Step 4: Convert pairSet to a sorted list of lists
        if (countZero > 2) {
            ArrayList<Integer> zeroPair = new ArrayList<>();
            zeroPair.add(0);
            zeroPair.add(0);
            pairSet.add(zeroPair);
            countZero -= 2;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(pairSet);
        result.sort(Comparator.comparingInt(a -> a.get(0)));
        return result;
    }
}
