package assignments.five;

import java.util.Arrays;
import java.util.HashMap;

public class Pangram {
    public static void main(String[] args) {
        String sentence = "abcdefghijklmnopqrstuvwxyZ";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = sentence.toCharArray();
        for (char c : charArray) {
            if (map.getOrDefault(c, 0) == 0) {
                map.put(c, 1);
                count++;
            }
        }
        return count == 26;
    }
}
