package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2,3}, s = {1,1};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        // Sort the greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;

        // Iterate until we run out of children or cookies
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // Assign cookie to the child
                child++;
            }
            // Move to the next cookie
            cookie++;
        }

        return child; // Number of content children
    }
}
