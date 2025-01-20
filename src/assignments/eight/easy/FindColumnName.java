package assignments.eight.easy;

//https://leetcode.com/problems/excel-sheet-column-title/description/
public class FindColumnName {
    public static void main(String[] args) {
        //System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--; //Excel column titles are 1-based, whereas java is 0-based
            int curr = columnNumber % 26;
            columnNumber /= 26;
            sb.append((char)(curr + 'A'));
        }
        return sb.reverse().toString();
    }
}
