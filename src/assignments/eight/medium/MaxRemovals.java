package assignments.eight.medium;

import java.util.HashSet;

//https://leetcode.com/problems/maximum-number-of-removable-characters/description/
public class MaxRemovals {
    public static void main(String[] args) {
        String s = "abcacb";
        String p = "ab";
        int[] removable = {3,1,0};
        System.out.println(maximumRemovals(s, p, removable));
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        //using binary search on removable because
        //If p is a subsequence of s after removing the first k characters (from removable), then p will also be a subsequence after removing any fewer characters (k' < k).
        //Conversely, if p is not a subsequence after removing k characters, it will also not be a subsequence after removing any more characters (k' > k).
        //hence it is a searching algorithm to find the correct removable[i]

        int left = 0, right = removable.length;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormSubSequence(s, p, removable, mid)) {
                res = mid; // Update res since p is still a subsequence
                left = mid + 1; // Try for a larger k
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static boolean canFormSubSequence(String s, String p, int[] removable, int k) {
        HashSet<Integer> removedIndices = new HashSet<>();
        for (int i = 0; i < k; i++) {// Only add the first k indices as that is the mid and we are checking only till mid
            removedIndices.add(removable[i]);
        }

        int pIndex = 0;
        for (int i = 0; i < s.length() && pIndex < p.length(); i++) {
            if (removedIndices.contains(i)) {
                continue; //skip removed characters
            }
            if (s.charAt(i) == p.charAt(pIndex)) {
                pIndex++;
            }
        }
        return pIndex == p.length();
    }
}
