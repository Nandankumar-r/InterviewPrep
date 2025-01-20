package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
public class IsArithmeticProgression {
    public static void main(String[] args) {
        int[] arr = {13,12,-12,9,9,16,7,-10,-20,0,18,-1,-20,-10,-8,15,15,16,2,15};
        System.out.println(canMakeArithmeticProgression(arr));
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
