package assignments.eight.medium;

//https://leetcode.com/problems/swap-adjacent-in-lr-string/description/
public class TransformString {
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    public static boolean canTransform(String start, String result) {
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }
        int i = 0, j = 0, n = start.length();

        while (i < n && j < n) {
            // Skip all 'X' in both strings
            while (i < n && start.charAt(i) == 'X')
                i++;
            while (j < n && result.charAt(j) == 'X')
                j++;

            // If both pointers are at the end, strings are valid
            if (i == n && j == n)
                return true;
            // If one pointer reaches the end but the other doesn't, invalid
            if (i == n || j == n)
                return false;

            if (start.charAt(i) != result.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'L' && i < j) return false; // L cannot move right, XL is replaced with LX where L moves only left
            if (start.charAt(i) == 'R' && i > j) return false; // R cannot move left, RX is replaced with XR where R moves only right

            i++;
            j++;
        }
        return true;
    }
}
