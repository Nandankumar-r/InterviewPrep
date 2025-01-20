package assignments.bitOperators;

public class SetNthBit {
    public static void main(String[] args) {
        int n = 67; //1000011
        System.out.println(setNthBit(n, 4)); // 83 - 1010011
    }

    private static int setNthBit(int n, int bit) {
        return (n | (1 << bit));
    }
}
