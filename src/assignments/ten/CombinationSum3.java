package assignments.ten;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 sum = new CombinationSum3();
        System.out.println(sum.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int k, int n, int start, ArrayList<Integer> currentRes, List<List<Integer>> res) {
        if (n == 0 && currentRes.size() == k) {
            res.add(new ArrayList<>(currentRes));
            return;
        }
        if (currentRes.size() > k) {
            return;
        }
        for (int j = start; j <= 9; j++) {
            currentRes.add(j);
            backtrack(k, n - j, j + 1, currentRes, res);
            currentRes.remove(currentRes.size() - 1);
        }
    }

}
