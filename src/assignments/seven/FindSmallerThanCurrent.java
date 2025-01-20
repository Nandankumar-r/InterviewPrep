package assignments.seven;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
public class FindSmallerThanCurrent {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        //copy array to a different variable
        //sort the copied array
        //store in hashmap - (nums[i], i)
        //loop over nums and check the map and alter copied array with the map.get(nums[i])
        int[] arrCopy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrCopy[i] = nums[i];
        }
        Arrays.sort(arrCopy);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrCopy.length; i++) {
            if (!map.containsKey(arrCopy[i])) {
                map.put(arrCopy[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            arrCopy[i] = map.get(nums[i]);
        }
        return arrCopy;
    }
}
