package assignments.bitOperators;

public class FindPowerOfNum {
    public static void main(String[] args) {
        int base = 2, power = 5;
        int res = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                res *= base;
            }
            base *= base;
            power = power >> 1;
        }
        System.out.println(res);
    }
}
