package assignments.bitOperators;

//Amazon question

//Magic Number - convert a given number to binary and add each bit * 5 power(1 to n)
//example 5th magic number is as follows
// binary of 5 - 101
// res = 1 * Math.pow(5,1) + 0 * Math.pow(5,2) + 1 * Math.pow(5,3) = 5 + 0 + 125 = 130

//Time complexity - number of bits in N i.e., O(logN)
public class FindNthMagicNumber {
    public static void main(String[] args) {
        System.out.println(findNthMagicNumber(6));
    }

    public static int findNthMagicNumber(int n) {
        int res = 0, base = 5;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            res += last * base;
            base *= 5;
        }
        return res;
    }
}
