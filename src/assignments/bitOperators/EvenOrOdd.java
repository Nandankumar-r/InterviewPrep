package assignments.bitOperators;

public class EvenOrOdd {
    public static void main(String[] args) {
        int n = 13;
        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
