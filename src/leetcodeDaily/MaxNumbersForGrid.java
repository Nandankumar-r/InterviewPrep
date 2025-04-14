package leetcodeDaily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxNumbersForGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};
        System.out.println(Arrays.toString(maxPoints(grid, queries)));
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        int[] result = new int[qLen];

        // Min-Heap for expanding grid cells in increasing order {value, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        // 4 directions
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count = 0; // Number of cells visited

        for (int[] query : sortedQueries) {
            int queryValue = query[0], index = query[1];

            while(!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                count++;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[] {grid[nr][nc], nr, nc});
                    }
                }
            }
            result[index] = count;
        }
    return result;
    }
}
