package assignments.five;

import java.util.Arrays;

public class MaxPopulation {
    public static void main(String[] args) {
        int[][] image = {
                {2000, 20001}
        };
        int res = maximumPopulation(image);
        System.out.println(res);
    }

    public static int maximumPopulation(int[][] logs) {
       int[] res = new int[2051];
        for (int[] log : logs) {
            res[log[0]] += 1;
            res[log[1]] += -1;
        }
        int maxNum = res[1950], maxYear = 1950;

        for (int i = 1951; i < res.length; i++) {
            res[i]  = res[i] + res[i-1];
            if (res[i] > maxNum) {
                maxNum = res[i];
                maxYear = i;
            }
        }
        return maxYear;
    }
}
