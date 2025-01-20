package assignments.ten;

//Time: O(logN)
//Space: O(logN)
public class CountSteps {
    public static void main(String[] args) {
        int n = 41;
        System.out.println(countStepsToZero(n));
    }

    private static int countStepsToZero(int n) {
        int count = 0;
        return helper(n, count);
    }

    private static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            return helper(n/2, ++count);
        } else {
            return helper(n-1, ++count);
        }
    }
}
