package leetcodeDaily;

import java.util.Arrays;
import java.util.HashMap;

//leetcode 2965
public class MIssingAndDouble {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3},
                {2,2}
        };
        MIssingAndDouble obj = new MIssingAndDouble();
        System.out.println(Arrays.toString(obj.findMissingAndRepeatedValues(grid)));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = {-1, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
                } else {
                    map.put(grid[i][j], 1);
                }
            }
        }

        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                res[0] = i;
            }
            if (!map.containsKey(i)) {
                res[1] = i;
            }
        }
        return res;

    }
}
