package assignments.leetcodeDaily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/map-of-highest-peak/description/
public class WaterLandHeight {
    public static void main(String[] args) {
        int[][] isWater = {
                {0, 1},
                {0, 0}
        };

        int[][] result = highestPeak(isWater);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];

        // Directions for moving in 4 directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Initialize queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Initialize height matrix and enqueue all water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0; // Water cells have height 0
                    queue.add(new int[]{i, j}); // Add water cells to the queue
                } else {
                    height[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Traverse all 4 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if the cell is unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && height[newX][newY] == -1) {
                    height[newX][newY] = height[x][y] + 1; // Assign height
                    queue.add(new int[]{newX, newY}); // Enqueue the cell
                }
            }
        }

        return height;
    }
}
