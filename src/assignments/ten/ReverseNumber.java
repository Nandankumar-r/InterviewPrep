package assignments.ten;

//Time: O(n)
//Space: O(n)
public class ReverseNumber {
    public static void main(String[] args) {
        int n = 1234;
        //Math.log10(n) + 1 = number of digits
        System.out.println(reverseNumber(n, (int) Math.log10(n)));
    }

    private static int reverseNumber(int n, int digits) {
        if (n < 10) {
            return n;
        }
        int rem = (int) ((n % 10) * Math.pow(10, digits--));
        return rem + reverseNumber(n / 10, digits);
    }
}
