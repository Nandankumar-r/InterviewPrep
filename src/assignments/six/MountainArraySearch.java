package assignments.six;

public class MountainArraySearch {
    public static void main(String[] args) {
        int[] mountainArr = new int[]{1,2,3,4,5,3,1};
        System.out.println(findInMountainArray(3, mountainArr));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeakIndex(mountainArr);
        int firstTry = binarySearch(target, mountainArr, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return binarySearch(target, mountainArr, peak + 1, mountainArr.length - 1);
    }
    private static int findPeakIndex(int[] mountainArr) {
        int start = 0, end = mountainArr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] > mountainArr[mid+1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static int binarySearch(int target, int[] mountainArr, int start, int end) {
        boolean isAsc = mountainArr[start] < mountainArr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target > mountainArr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < mountainArr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
