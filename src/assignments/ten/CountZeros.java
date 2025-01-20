package assignments.ten;
//Time: O(logN)
//Space: O(logN)
public class CountZeros {
    public static void main(String[] args) {
        int n = 131343;
        System.out.println(countNumZeros(n));
    }

    private static int countNumZeros(int n) {
        if (n < 10) {
            return 0;
        }
        int res = n % 10 == 0 ? 1 : 0;
        return res + countNumZeros(n/10);
    }
}
