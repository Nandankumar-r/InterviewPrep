package leetcodeDaily;

import java.util.Arrays;

public class MeetingFreeDays {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings ={
                {5,7},{1,3},{9,10}
        };
        System.out.println(countDays(days, meetings));
    }
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // sort array based on meeting start days
        int prev_end = 0;

        for(int[] meeting : meetings) {
            int start = Math.max(meeting[0], prev_end + 1); // It is either current start or prev_end + 1 due to overlapping of meetings
            int length = meeting[1] - start + 1;
            days -= Math.max(length, 0); // to avoid negative we get max with 0
            prev_end = Math.max(prev_end, meeting[1]);
        }
        return days;
    }
}
