package assignments.eight.easy;

//http://leetcode.com/problems/reverse-prefix-of-word/description/
public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder s = new StringBuilder();
        int index = word.indexOf(ch);
        int temp = index + 1;
        if (index != -1) {
            while (index >= 0) {
                s.append(word.charAt(index));
                index--;
            }
            while (temp <= word.length() - 1) {
                s.append(word.charAt(temp++));
            }
            return s.toString();
        } else {
            return word;
        }
    }
}
