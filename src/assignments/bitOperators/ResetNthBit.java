package assignments.bitOperators;

public class ResetNthBit {
    public static void main(String[] args) {
        int n = 67; //1000011
        System.out.println(reSetNthBit(n, 1)); // 65 - 1000001
    }

    private static int reSetNthBit(int n, int bit) {
        //~ -> compliment
        //& -> and
        //| -> or
        //^ -> xor
        return (n & (~(1 << bit)));
    }
}
