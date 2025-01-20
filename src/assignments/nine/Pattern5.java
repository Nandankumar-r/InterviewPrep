package assignments.nine;

public class Pattern5 {
	public static void main(String[] args) {
		int row = 5;
        for (int i = 0; i < 2 * row; i++) {
            int totalColsInRow = i > row ? 2 * row - i : i;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("*");
                if (col != totalColsInRow - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
	}
}
