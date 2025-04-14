package leetcodeDaily;

import java.util.Arrays;

public class ValidCuts {
    public static void main(String[] args) {
        int[][] rectangles = {
                {1, 0, 5, 2},
                {0, 2, 2, 4},
                {3, 2, 5, 3},
                {0, 4, 4, 5}
        };
        int n = 5;
        System.out.println(checkValidCuts(n, rectangles));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] x = Arrays.stream(rectangles)
                .map(a -> new int[] {a[0], a[2]})
                .toArray(int[][]::new);
        int[][] y = Arrays.stream(rectangles)
                .map(a -> new int[] {a[1], a[3]})
                .toArray(int[][]::new);

        Arrays.sort(x, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(y, (a, b) -> Integer.compare(a[0], b[0]));

        return Math.max(nonOverLapping(x), nonOverLapping(y)) >= 3;
    }

    private static long nonOverLapping(int[][] intervals) {
        int count = 0;
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (prevEnd <= interval[0]) { //non overlapping
                count += 1;
            }
            prevEnd = Math.max(interval[1], prevEnd);
        }
        return count;
    }
}
