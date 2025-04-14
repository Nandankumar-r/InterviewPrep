package DSAMustSolve;

public class Kadane {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for (int num : arr) {
            curr_sum += num;
            max_sum = Math.max(max_sum, curr_sum);
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        System.out.println(max_sum);
    }
}
