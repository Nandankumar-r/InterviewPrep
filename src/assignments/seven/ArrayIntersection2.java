package assignments.seven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class ArrayIntersection2 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        Integer i = new Integer(8);
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int j : nums1) {
            Integer k = (Integer) j;
            int count = map.getOrDefault(j, 0);
            map.put(j, count + 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                map.put(j, map.get(j) - 1);
                res.add(j);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
