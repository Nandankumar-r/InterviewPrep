package DSAMustSolve;

import java.util.HashMap;

public class SlidingWindowMock {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(getMaxWindowSize(s, k));
    }

    public static int getMaxWindowSize(String s, int k) {
        int l = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window if distinct count > k
            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
