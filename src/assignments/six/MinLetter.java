package assignments.six;

public class MinLetter {
    public static void main(String[] args) {
        char[] letters = new char[] {'a', 'c', 'd', 'f', 'i', 'y'};
        char res = getMinimumNextLetter(letters, 'y');
        System.out.println(res);
    }

    public static char getMinimumNextLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0, end = n -1;
        while (start <= end) {
            int mid = start + (end -start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % n];
    }
}
