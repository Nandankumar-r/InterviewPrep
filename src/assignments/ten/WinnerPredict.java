package assignments.ten;

public class WinnerPredict {
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        WinnerPredict winnerPredict = new WinnerPredict();
        System.out.println(winnerPredict.PredictTheWinner(nums));
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n]; // Memoization table
        //return scoreDifference(nums, 0, n - 1) >= 0; //Recursive
        return scoreDifferenceDP(nums, 0, n - 1, memo) >= 0;
    }

    private int scoreDifferenceDP(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) {
            return nums[left]; // Only one element left, so take it
        }

        if (memo[left][right] != null) {
            return memo[left][right]; // Return precomputed result
        }

        // Player chooses left or right, opponent will try to minimize our score
        //The minus (-) is needed because after you take a number, the next player also plays their best,
        // so you subtract their best score to see how much you’re really winning by
        int pickLeft = nums[left] - scoreDifferenceDP(nums, left + 1, right, memo);
        int pickRight = nums[right] - scoreDifferenceDP(nums, left, right - 1, memo);

        memo[left][right] = Math.max(pickLeft, pickRight);
        // The player chooses the option that maximizes their score difference
        return memo[left][right];
    }

    private int scoreDifference(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left]; // Only one element left, so take it
        }

        // Player chooses left or right, opponent will try to minimize our score
        //The minus (-) is needed because after you take a number, the next player also plays their best,
        // so you subtract their best score to see how much you’re really winning by
        int pickLeft = nums[left] - scoreDifference(nums, left + 1, right);
        int pickRight = nums[right] - scoreDifference(nums, left, right - 1);

        // The player chooses the option that maximizes their score difference
        return Math.max(pickLeft, pickRight);
    }
}
