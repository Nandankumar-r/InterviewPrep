package assignments.ten;

//Time: O(n)
//Space: O(n)
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
