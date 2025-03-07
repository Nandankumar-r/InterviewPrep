package assignments.ten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CominationSum2 {
    public static void main(String[] args) {
        CominationSum2 sum = new CominationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(sum.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); //to handle duplicates easily
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, ArrayList<Integer> currentList, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) { //to handle duplicates
                continue;
            }
            if (candidates[i] > target) { // no point in considering for the solution if it's > target
                break;
            }
            currentList.add(candidates[i]); //consider current element as a possible solution
            backtrack(candidates, target - candidates[i], i + 1, currentList, res);
            currentList.remove(currentList.size() - 1); // backtrack and try again
        }
    }

}
