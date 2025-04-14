package leetcodeDaily;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumCostWalk {
    public static void main(String[] args) {
        MinimumCostWalk obj = new MinimumCostWalk();
        int n = 5;
        int[][] edges = {
                {0,1,7},
                {1,3,7},
                {1,2,1}
        };
        int[][] query = {
                {0, 3},
                {3, 4}
        };

        System.out.println(Arrays.toString(obj.minimumCost(n, edges, query)));
    }

    public class UnionFind {
        int[] parent;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                //combine x & y components
                if (size[x] < size[y]) {
                    parent[x] = y;
                    size[y] += size[x];
                } else {
                    parent[y] = x;
                    size[x] += size[y];
                }
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // cost of walk = bitwise AND of the weights in the path
        // weights >= 0
        // multiple components in the graph (maybe Disjoint) in nature
        // we not only consider shortest path because AND might reduce the walk value.
        // so ideally we should consider all the edges as AND only reduces the value not increase it.
        // if we revisit a edge it's not an issue (n & n = n)

        // 1. Build the components
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        // 2. Get cost of each component
        HashMap<Integer, Integer> component_cost = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[2];
            int root = uf.find(u);
            if (!component_cost.containsKey(root)) {
                component_cost.put(root, w);
            } else {
                component_cost.put(root, component_cost.get(root) & w);
            }
        }

        // 3. Query search
        int[] res = new int[query.length];
        int i = 0;
        for (int[] q : query) {
            int r1 = uf.find(q[0]);
            int r2 = uf.find(q[1]);
            if (r1 != r2) {
                res[i++] = -1;
            } else {
                res[i++] = component_cost.get(r1);
            }
        }
        return res;
    }
}
