package assignments.nine;

public class Pattern6 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 0; i < row; i++) {
            // space: row - i - 1
            // * = row number
            for (int spaces = 0; spaces < row - i - 1; spaces++) {
                System.out.print("  ");
            }
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
