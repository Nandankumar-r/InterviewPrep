package assignments.nine;

public class Pattern3 {
    public static void main(String[] args) {
        int row = 5;
        for (int i = row; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
                if (j != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
