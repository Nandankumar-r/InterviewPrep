package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/height-checker/description/
public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int res = 0;
        boolean swapped = false;
        int[] sortedHeights = new int[heights.length];
        for (int j = 0; j < heights.length; j++) {
            sortedHeights[j] = heights[j];
        }
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = 1; j < heights.length - i; j++) {
                if (heights[j] < heights[j-1]) {
                    int temp = heights[j];
                    heights[j] = heights[j-1];
                    heights[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println(Arrays.toString(heights));
        for (int j = 0; j < heights.length; j++) {
            if (heights[j] != sortedHeights[j]) {
                res++;
            }
        }
        return res;
    }
}
