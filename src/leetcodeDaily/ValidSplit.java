package leetcodeDaily;

import java.util.Arrays;
import java.util.List;

public class ValidSplit {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,2,2);
        System.out.println(minimumIndex(nums));
    }

    public static int minimumIndex(List<Integer> nums) {
        int candidate = getMajority(nums); // Boyer Moore Algorithm
        if (candidate == -1) {
            return -1;
        }

        // Step 2: Count total occurrences of the candidate
        int totalFrequency = 0;
        for (int num : nums) {
            if (num == candidate) totalFrequency++;
        }

        // Step 3: Iterate and find the minimum index where the split is valid
        int countLeft = 0;
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) countLeft++;

            int countRight = totalFrequency - countLeft;

            // Check dominant conditions
            if (countLeft > (i + 1) / 2 && countRight > (n - (i + 1)) / 2) {
                return i;  // Return the first valid index
            }
        }

        return -1; // If no valid split found

    }

    private static int getMajority(List<Integer> nums) {
        int candidate = -1;
        int count = 0;
        // Step 1: Find the candidate
        for (Integer num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Verify if candidate appears more than n/2 times
        int freq = 0;
        for (Integer num : nums) {
            if (num == candidate) {
                freq++;
            }
        }

        return (freq > nums.size() / 2) ? candidate : -1;  // Return -1 if no majority element exists
    }
}
