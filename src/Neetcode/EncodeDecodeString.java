package Neetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        String[] strs = {"we","say",":","yes"};
        String encodedStr = encode(List.of(strs));
        System.out.println(encodedStr);
        System.out.println(decode(encodedStr));
    }

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
