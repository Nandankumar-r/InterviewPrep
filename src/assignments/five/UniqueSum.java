package assignments.five;

import java.util.Arrays;

public class UniqueSum {
    public static void main(String[] args) {
        int[] res = sumZero(7);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        if (n == 1) {
            return new int[]{0};
        }
        if (n % 2 != 0) {
            res[n-1] = 0;
            n = n-1;
        }
        int temp = n;
        for (int i = 0; i < n; i+=2) {
            res[i] = temp--;
            res[i+1] = -(res[i]);
        }
        return res;
    }
}
