package assignments.ten.backtracking;

public class IncreasingNumbers {
    public static void main(String[] args) {
        printIncreasingNumbers(0);
    }

    public static void printIncreasingNumbers(int n) {
        generateNumbers(n, 1, new StringBuilder());
    }

    private static void generateNumbers(int n, int start, StringBuilder num) {
        // Base Case: If number has 'n' digits, print and return
        if (num.length() == n) {
            System.out.print(num + " ");
            return;
        }

        // Try adding digits from 'start' to 9 (ensuring increasing order)
        for (int i = start; i <= 9; i++) {
            num.append(i);
            generateNumbers(n, i + 1, num);
            num.deleteCharAt(num.length() - 1);
        }
    }
}
