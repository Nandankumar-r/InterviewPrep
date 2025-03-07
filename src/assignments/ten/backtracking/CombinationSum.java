package assignments.ten.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(nums, target));
    }

    //[[2,2,2,2],[2,3,3],[3,5]]
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combineSumToTarget(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void combineSumToTarget(int[] candidates, int target, int start, ArrayList<Integer> currRes, List<List<Integer>> res) {
        // Base case: If the remaining target is 0, add a copy of current combination to the result.
        if (target == 0) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currRes.add(candidates[i]);
            combineSumToTarget(candidates, target - candidates[i], i, currRes, res);
            currRes.remove(currRes.size() - 1);
        }

    }
}
