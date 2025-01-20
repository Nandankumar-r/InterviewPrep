package assignments.eight.easy;

public class StringComparision {
    public static void main(String[] args) {
        String[] word1 ={"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "", s2 = "";
        for(String word : word1) {
            s1 += word;
        }
        for(String word : word2) {
            s2 += word;
        }
        return s1.equals(s2);
    }
}
