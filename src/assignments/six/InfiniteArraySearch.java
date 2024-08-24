package assignments.six;

//Infinite array means we can't calculate the length of the array so arr.length cannot be used
//Binary search
public class InfiniteArraySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(findSubArrayToSearch(nums, 7));
    }
    public static int findSubArrayToSearch(int[] nums, int target) {
        //start with a box value of 2
        int start = 0, end = 1;
        while (target > nums[end]) {
            int temp = end + 1;
            //double the box value and compare the nums[end] to target and keep increasing till the end bound is found
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(nums, target, start, end);
    }

    private static int search (int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }
}
