package assignments.eight.medium;

//https://leetcode.com/problems/sentence-similarity-iii/
public class StingSimilarity {
    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "My Haley";
        System.out.println(areSentencesSimilar(s1, s2));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1;
        String[] s2;
        if (sentence1.length() < sentence2.length()) {
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        } else {
            s1 = sentence2.split(" ");
            s2 = sentence1.split(" ");
        }

        int l1 = 0, l2 = 0, r1 = s1.length - 1, r2 = s2.length - 1;

        while (l1 < s1.length && l2 < s2.length && s1[l1].equals(s2[l2])) {
            l1++;
            l2++;
        }

        while (r1 >= 0 && r2 >= 0 && s1[r1].equals(s2[r2])) {
            r1--;
            r2--;
        }

        return l1 > r1;
    }
}
