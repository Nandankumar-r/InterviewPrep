package leetcodeDaily;

import java.util.HashMap;

//leetcode 3306
public class CountOfSubstring {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public static long countOfSubstrings(String word, int k) {
        // Count substrings with exactly k consonants
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private static long atLeastK(String word, int k) {
        long numValidSubstrings = 0; // Stores the count of valid substrings
        int start = 0; // Left pointer of sliding window
        int end = 0;   // Right pointer of sliding window

        // Map to keep track of vowel frequency in the window
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0; // Count of consonants in the current window

        // Expand the window by moving the 'end' pointer
        while (end < word.length()) {
            char newLetter = word.charAt(end);

            // If it's a vowel, update the frequency in the HashMap
            if (isVowel(newLetter)) {
                vowelCount.put(newLetter, vowelCount.getOrDefault(newLetter, 0) + 1);
            } else { // Otherwise, it's a consonant
                consonantCount++;
            }

            // Try to shrink the window from the left while it's valid
            while (vowelCount.size() == 5 && consonantCount >= k) {
                // Count substrings that start from `start` and end anywhere from `end` to `word.length() - 1`
                numValidSubstrings += word.length() - end;

                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    // Reduce vowel frequency
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    // Remove vowel from the map if count becomes zero
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    // Reduce consonant count
                    consonantCount--;
                }
                // Shrink the window
                start++;
            }

            // Expand the window
            end++;
        }

        return numValidSubstrings;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


}
