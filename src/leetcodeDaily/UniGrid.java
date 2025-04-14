package leetcodeDaily;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UniGrid {
    public static void main(String[] args) {
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        System.out.println(minOperations(grid, x));
    }

    public static int minOperations(int[][] grid, int x) {
        // 1. Convert to 2D array
        int[] grid2D = Stream.of(grid)
                        .flatMapToInt(IntStream :: of)
                                .toArray();

        // 2. Check divisibility
        int remainder = grid2D[0] % x;
        for (int num : grid2D) {
            if (num % x != remainder) {
                return -1;
            }
        }

        // 3. Choose Median and calculate number of operations
        Arrays.sort(grid2D);
        int median = grid2D[grid2D.length / 2];
        int res = 0;
        for (int num : grid2D) {
            res += Math.abs(num - median) / x;
        }

        return res;
    }
}
