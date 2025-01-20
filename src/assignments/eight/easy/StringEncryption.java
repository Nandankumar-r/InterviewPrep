package assignments.eight.easy;

//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/
public class StringEncryption {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(i < str.length - 2 && str[i + 2] == '#') {
                int n = (str[i] - '0') * 10 + (str[i + 1] - '0');
                sb.append((char)('j' + n - 10));
                i += 2;
            }
            else sb.append((char)('a' + str[i] - '1'));
        }
        return sb.toString();
    }
}
