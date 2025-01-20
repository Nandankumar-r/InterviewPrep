package assignments.bitOperators;

public class FindXorBetweenNums {
    public static void main(String[] args) {
        //Range XOR from a to b = XOR(b) ^ XOR(a-1)
        int a = 3, b = 19;
        int res = findXor(b) ^ findXor(a - 1);
        System.out.println(res);
    }

    public static int findXor(int num) {
        if (num % 4 == 0) {
            return num;
        }
        if (num % 4 == 1) {
            return 1;
        }
        if (num % 4 == 2) {
            return num + 1;
        }
        return 0;
    }
}
