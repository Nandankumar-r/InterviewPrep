package assignments.bitOperators;

public class PowOfTwo {
    public static void main(String[] args) {
        int n = -8;
        if (n == 0) {
            System.out.println("false");
        } else {
            boolean res = (n & (n - 1)) == 0;
            System.out.println(res);
        }
    }
}
