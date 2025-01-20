package assignments.eight.easy;

//https://leetcode.com/problems/merge-strings-alternately/description/
public class StringAlternateMerge {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("Nandan", "Kumar"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder s = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            s.append(word1.charAt(i++));
            s.append(word2.charAt(j++));
        }
        while (i < word1.length()) {
            s.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            s.append(word2.charAt(j++));
        }
        return s.toString();
    }
}
