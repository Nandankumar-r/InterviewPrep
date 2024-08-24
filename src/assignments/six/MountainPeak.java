package assignments.six;

public class MountainPeak {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,4,7,3,2,1};
        System.out.println(findPeak(nums));
    }
    public static int findPeak(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Compare middle element with its neighbors
            if (nums[mid] > nums[mid + 1]) {
                // If mid is greater than mid+1, move towards the left (a peak is on the left side)
                end = mid;
            } else {
                // Otherwise, move towards the right (a peak is on the right side)
                start = mid + 1;
            }
        }
        // start and end converge to the peak
        return start;
    }
}
