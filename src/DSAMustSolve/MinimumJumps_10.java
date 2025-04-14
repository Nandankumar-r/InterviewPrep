package DSAMustSolve;

public class MinimumJumps_10 {
    public static void main(String[] args) {
        int[] nums = {1,3,10,8,9,3,6,7,6,8,9};
        System.out.println(minJumps(nums));
    }

    public static int minJumps(int[] arr) {
        int l = 0, r = 0;
        int res = 0;
        while (r < arr.length - 1) {
            int farthest = 0;
            for (int i = l; i < r + 1; i++)
                farthest = Math.max(farthest, i + arr[i]);
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}
