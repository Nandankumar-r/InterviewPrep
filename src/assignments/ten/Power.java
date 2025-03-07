package assignments.ten;

public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        double x = 2.0;
        int n = -1;
        long exp = n;  // Convert to long to avoid integer overflow
        if (n < 0) {
            exp = -exp;  // Convert negative exponent to positive
            x = 1 / x;    // Invert x for negative exponent
        }
        double res = power.power(x, exp);
        System.out.println(res);
    }

    public double power(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);
        double res = half * half;

        if (n % 2 == 1) {
            res *= x;
        }
        return res;
    }
}
