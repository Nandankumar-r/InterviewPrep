package assignments.five;

public class Jump {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static  boolean canJump(int[] nums) {
        int n = nums.length, reachable = 0;
        for (int i = 0; i < n && i <= reachable; i++) {
            reachable = Math.max(reachable, nums[i] + i);
            if (reachable >= n) return true;
        }
        return false;
    }
}
