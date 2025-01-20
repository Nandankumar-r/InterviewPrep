package assignments.nine;

public class Pattern12 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= 2 * row; i++) {
            int spaces = Math.min(i - 1, 2 * row - i);
            int cols = row - spaces;

            for (int space = 1; space <= spaces; space++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
                if (j != cols) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
