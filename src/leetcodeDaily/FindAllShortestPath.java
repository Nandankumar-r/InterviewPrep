package leetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FindAllShortestPath {
    public static void main(String[] args) {
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };
        int n = 7;
        FindAllShortestPath obj = new FindAllShortestPath();
        System.out.println(obj.countPaths(n, roads));
    }
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        // 1. Create Adjacency list / graph
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adjList.get(u).add(new int[] {v, time});
            adjList.get(v).add(new int[] {u, time});
        }

        // 2. Initialise dist and ways array.
        // dist[] -> stores the shortest distance from u -> v
        // ways[] -> number of shortest ways

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // 3. use priorityQueue as a minheap and perform Dijkstra's

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0])); // stores {distance, node}
        queue.offer(new long[] {0, 0});

        while(!queue.isEmpty()) {
            long[] curr = queue.poll();
            long curDist = curr[0];
            int curNode = (int) curr[1];

            // Ignore if we already have a shorter path
            if (curDist > dist[curNode]) continue;

            // 4. Relax all it's neighbours

            for (int[] neighbour : adjList.get(curNode)) {
                int nextNode = neighbour[0];
                long distance = neighbour[1];

                if (dist[nextNode] > distance + curDist) {
                    dist[nextNode] = distance + curDist;
                    ways[nextNode] = ways[curNode];
                    queue.offer(new long[] {dist[nextNode], nextNode});
                } else if (dist[nextNode] == distance + curDist) {
                    ways[nextNode] = (ways[nextNode] + ways[curNode]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}
