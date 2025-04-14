package DSAMustSolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] currInterval = intervals[0];
        List<int[]> merged = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currInterval[1] >= nextInterval[0]) { //merge
                currInterval[1] = Math.max(currInterval[1], nextInterval[1]);
            } else {
                merged.add(currInterval);
                currInterval = nextInterval;
            }
        }
        merged.add(currInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
