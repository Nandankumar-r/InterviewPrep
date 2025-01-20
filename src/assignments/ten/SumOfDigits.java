package assignments.ten;

//Time: O(logN)
//Space: O(logN)
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(1111101));
    }
    public static long sum(int n) {
        if (n < 10) {
            return n;
        }
        int digit = n % 10;
        return digit + sum(n / 10);
    }
}
