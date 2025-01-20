package assignments.ten;

public class PatternUsingRecursion {
    public static void main(String[] args) {
        patterPrint(4, 0);
    }

    public static void patterPrint(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print("* ");
            patterPrint(r, ++c);
            //System.out.print("* "); //To print triangle in reverse order
        } else {
            System.out.println();
            patterPrint(--r, 0);
            //System.out.println(); //To print triangle in reverse order
        }
    }
}
