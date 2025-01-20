package assignments.bitOperators;

public class FindNegativeNum {
    public static void main(String[] args) {
        int n = 34;
        System.out.println(findNegativeNumber(n));
        int n1 = -34;
        System.out.println(findNegativeNumber(n1));
    }

    //2's compliment will give negative number
    private static int findNegativeNumber(int n) {
        //step 1: compliment the given number
        n = ~n;
        //step 2: add 1 to the number
        return n + 1;
    }

}
