package leetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class CombineToN {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1);
        return res;
    }

    private static void dfs(int n, int k, ArrayList<Integer> path, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            // consider taking i
            path.add(i);
            dfs(n, k, path, i + 1);
            // don't consider taking i
            path.remove(path.size() - 1);
        }
    }
}
