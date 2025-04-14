package leetcodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoOfComponents {
    public static void main(String[] args) {
        int n = 6;
        int [][] edges = {{0,1},{0,2},{1,2},{3,4}};
        NoOfComponents obj = new NoOfComponents();
        System.out.println(obj.countCompleteComponentsBFS(n, edges));
    }

    public class UnionFind {
        int[] parent, size;
        public UnionFind (int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                return find(parent[x]);
            }
            return parent[x];
        }

        public void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }

    public int countCompleteComponentsUF(int n, int[][] edges) {
        HashMap<Integer, Integer> nodeCount = new HashMap<>();
        HashMap<Integer, Integer> edgeCount = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        // 1. construct the components
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        // 2. count number of nodes and edges in each component
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0) + 1);
        }

        for (int[] edge : edges) {
            int root = uf.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        // 3. check for completeness, if a component has x nodes then each node should have x - 1 edges.
        // Since it's undirected graph total edges is (x * (x - 1)) / 2
        int res = 0;
        for (int root : nodeCount.keySet()) {
            int nodes = nodeCount.get(root);
            int edgesForRoot = edgeCount.getOrDefault(root, 0);

            if (edgesForRoot == (nodes * (nodes - 1)) / 2) {
                res++;
            }
        }

        return res;
    }

    public int countCompleteComponentsDFS(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        // 1. create adjacency list
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // 2. create components using DFS
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                int count[] = new int[2]; // nodes -> edges
                dfs(node, adjList, visited, count);

                int nodeCount = count[0];
                int edgeCount = count[1] / 2; // each edge is counted twice due to undirected nature of the graph

                if (edgeCount == (nodeCount * (nodeCount - 1)) / 2) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int node, HashMap<Integer, List<Integer>> adjList, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++;
        count[1] += adjList.get(node).size();
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited, count);
            }
        }
    }

    public int countCompleteComponentsBFS(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        // 1. create adjacency list
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // 2. create components using BFS
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                int[] count = new int[2];
                count = bfs(node, adjList, visited, count);

                int nodeCount = count[0];
                int edgeCount = count[1] / 2; // each edge is counted twice due to undirected nature of the graph

                if (edgeCount == (nodeCount * (nodeCount - 1)) / 2) {
                    res++;
                }
            }
        }
        return res;
    }

    private int[] bfs(int node, HashMap<Integer, List<Integer>> adjList, boolean[] visited, int[] count) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        int nodeCount = 0;
        int edgeCount = 0;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            nodeCount++;
            edgeCount += adjList.get(n).size();

            for (int neighbour : adjList.get(n)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return new int[]{nodeCount, edgeCount};
    }

}
