package assignments.nine;

public class Pattern2 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
                if (i != j) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
