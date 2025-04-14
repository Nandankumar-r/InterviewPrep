package leetcodeDaily;

import java.util.HashMap;
import java.util.Map;

public class MaxScore {
    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        Map<Integer, Long> dp = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int jumpTo = i + brainpower + 1;

            long take = points + dp.getOrDefault(jumpTo, 0L);
            long skip = dp.getOrDefault(i + 1, 0L);

            dp.put(i, Math.max(take, skip));
        }

        return dp.getOrDefault(0, 0L);
    }

}
