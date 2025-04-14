package leetcodeDaily;

public class NumberOfSubstrings {
    public static void main(String[] args) {
        NumberOfSubstrings obj = new NumberOfSubstrings();
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        int[] map = new int[3]; //map to store count of a,b,c
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            map[s.charAt(r) - 'a']++; // Add character to the window
            while (map[0] > 0 && map[1] > 0 && map[2] > 0) {
                res += s.length() - r; // All substrings from (l, r) to (l, end) are valid
                map[s.charAt(l) - 'a']--; // Shrink the window from the left
                l++; // Move left pointer
            }
        }
        return res;
    }
}
