package assignments.six;

public class RotatedBinarySearch2 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 1));
    }

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from consideration.
            } else {
                end--;
                start++;
            }
        }

        return false;
    }
}
