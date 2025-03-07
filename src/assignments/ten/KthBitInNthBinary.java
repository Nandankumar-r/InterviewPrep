package assignments.ten;

//S1 = "0"
//Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
public class KthBitInNthBinary {
    public static void main(String[] args) {
        KthBitInNthBinary obj = new KthBitInNthBinary();
        System.out.println(obj.findKthBit(3, 1));
        System.out.println(obj.findKthBitRecursion(3, 1));
    }

    //brute force
    public char findKthBit(int n, int k) {
        StringBuilder binary = new StringBuilder("0");
        for (int i = 1; i < n && k > binary.length(); i++) {
            binary.append('1');
            for (int j = binary.length() - 2; j >= 0; j--) {
                char invertedBit = binary.charAt(j) == '1' ? '0' : '1';
                binary.append(invertedBit);
            }
        }
        return binary.charAt(k - 1);
    }

    //Recursion
    public char findKthBitRecursion(int n, int k) {
        if (n == 1) return '0';
        int length = 1 << n; //2^n

        if (k < length / 2) {
            return findKthBit(n - 1, k);
        }
        else if (k == length / 2) {
            return '1';
        }
        else {
            char correspondingBit = findKthBit(n - 1, length - k);
            return (correspondingBit == '0') ? '1' : '0';
        }
    }
}
