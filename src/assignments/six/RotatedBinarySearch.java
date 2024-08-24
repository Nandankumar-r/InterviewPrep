package assignments.six;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {5,6,7,8,9,9,9,9,9,9,10,11,0,1,2,3,4};
        System.out.println(search(new int[]{1}, 1));
        //System.out.println(findPivotWithDuplicates(new int[]{1}));
    }

    public static int search(int[] nums, int target) {
            //int pivotIndex = findPivot(nums);
            int pivotIndex = findPivotWithDuplicates(nums);
            if (pivotIndex == -1) { // If -1 then array is not rotated so do a normal binary search
                return binarySearch(nums, target, 0, nums.length - 1);
            }
            if (target == nums[pivotIndex]) {
                return pivotIndex;
            }
            if (target >= nums[0]) { // If target is greater than the first element then that means the target must lie between 0 and pivot - 1, because the elements after the pivot is always lesser than the first element.
                return binarySearch(nums, target, 0, pivotIndex - 1);
            } else {
                return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
            }
    }

    public static int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            //Check 4 cases
            //1. element at index mid is greater than element at mid + 1, so return mid as there is only 1 pivot, and it's always the largest element.
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            //2. element at index mid is lesser than element at mid - 1, so return mid - 1 as there is only 1 pivot, and it's always the largest element.
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            //3. In a rotated array the elements after the pivot is always lesser than the first element. In such scenario reduce the search space by updating start to mid + 1
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }
            //4. The pivot must be in the left half
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch (int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // always calculate mid like this to avoid start+end exceeding the int limit
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findPivotWithDuplicates(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (start == end) {
            return 0;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            //Check 4 cases
            //1. element at index mid is greater than element at mid + 1, so return mid as there is only 1 pivot, and it's always the largest element.
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            //2. element at index mid is lesser than element at mid - 1, so return mid - 1 as there is only 1 pivot, and it's always the largest element.
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            //If elements at start, mid and end are equal then just skip them
            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                //check if start & end are pivot elements before skipping.
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            //if the left side of the array is sorted, search on the right side of the array
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[end] < nums[mid])) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
