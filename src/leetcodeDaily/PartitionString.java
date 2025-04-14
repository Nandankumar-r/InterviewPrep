package leetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int end = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                res.add((end - start) + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
