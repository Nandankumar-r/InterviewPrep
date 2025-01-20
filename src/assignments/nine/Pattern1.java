package assignments.nine;

public class Pattern1 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("*");
                if (j != row - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
