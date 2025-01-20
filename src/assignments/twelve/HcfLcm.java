package assignments.twelve;

public class HcfLcm {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        System.out.println("HCF = " + findHCF(a, b));
        System.out.println("LCM = " + findLCM(a, b));
    }

    private static int findLCM(int a, int b) {
        int res = (a * b) / findHCF(a, b);
        return res;
    }

    private static int findHCF(int a, int b) {
        if (a == 0) {
            return b;
        }
        return findHCF(b%a, a);
    }
}
