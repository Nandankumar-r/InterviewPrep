package assignments.nine;

public class Pattern9 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = row; i > 0; i--) {
            // space: row - i - 1
            // * = row number
            for (int spaces = 0; spaces < row - i; spaces++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
                if (j != i -1) {
                    System.out.print("*"); // for pattern 11 (below) replace with " " (space)
                }
            }
            System.out.println();
        }
    }
}

/*
11.  * * * * *
      * * * *
       * * *
        * *
         *
*/