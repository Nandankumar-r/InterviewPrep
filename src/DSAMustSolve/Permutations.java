package DSAMustSolve;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, visited, path);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
