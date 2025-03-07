package Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentOptimised(nums, 2)));
    }


    //brute force - O(n * n)
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int ele= -1;
            for(Integer key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    ele = key;
                }
            }
            if (!res.contains(ele)) {
                res.add(ele);
                map.remove(ele);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    //Using bucket sort - O(n)
    public static int[] topKFrequentOptimised(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Step 1: Count the frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a bucket array where the index represents the frequency
        // and each index stores a list of numbers with that frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill the bucket with numbers based on their frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        // Step 4: Extract the top K frequent elements from the bucket
        for (int i = bucket.length - 1; index < k && i > 0; i--) {
            for (int num : bucket[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
