package assignments.five;

import java.util.Arrays;

public class HighestAltitude {
    public static void main(String[] args) {
        int[] nums = {-5,1,5,0,-7};
        int res = largestAltitude(nums);
        System.out.println(res);
    }

    public static int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length+1];
        altitude[0] = 0;
        int largest = altitude[0];
        for (int i = 0; i < gain.length; i++) {
            altitude[i+1] = gain[i] + altitude[i];
            if (altitude[i+1] > largest)
                largest = altitude[i+1];
        }

        return largest;
    }
}
