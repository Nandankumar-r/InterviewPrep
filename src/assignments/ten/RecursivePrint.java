package assignments.ten;

//Time: O(n)
//Space: O(n)
public class RecursivePrint {
    public static void main(String[] args) {
        printDecreasing(5);
        System.out.println();
        printIncreasing(5);
    }

    private static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    private static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n - 1);
    }
}
