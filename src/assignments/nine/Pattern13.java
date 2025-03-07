package assignments.nine;

public class Pattern13 {
    public static void main(String[] args) {
        int row = 5;
        int i, j, k;

        // outer loop to handle rows
        for (i = 1; i <= row; i++) {
            // inner loop to print spaces.
            for (j = i; j < row; j++) {
                System.out.print(" ");
            }

            for (k = 1; k <= (2 * i - 1); k++) {
                // printing stars.
                if (k == 1 || i == row || k == (2 * i - 1)) {
                    System.out.print("*");
                }
                // printing spaces.
                else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

}
