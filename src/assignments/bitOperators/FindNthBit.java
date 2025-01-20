package assignments.bitOperators;

public class FindNthBit {
    public static void main(String[] args) {
        int n = 67; //1000011
        System.out.println(findNthBit(n, 6));
    }

    private static int findNthBit(int n, int bit) {
        //follows 0 bit indexing
        return ((n >> bit) & 1);
    }

}
