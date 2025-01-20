package assignments.eight.easy;

//https://leetcode.com/problems/maximum-repeating-substring/description/
public class MaxSubstring {
    public static void main(String[] args) {
        System.out.println(maxRepeating("abcabc", "ab"));
    }
    public static int maxRepeating(String sequence, String word) {
        int ans = 1;
        while (sequence.contains(word.repeat(ans)))
            ++ans;
        return ans - 1;
    }
}
