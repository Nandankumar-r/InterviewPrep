package assignments.eight.easy;

//https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
public class IsHalvesAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
    public static boolean halvesAreAlike(String s) {
        int count = 0, count2 = 0, i = 0, length = s.length() - 1;
        while(i < length) {
            if(check(s.charAt(i))) {
                count++;
            }
            if(check(s.charAt(length))) {
                count2++;
            }
            i++;
            length--;
        }
        return count==count2 ;
    }

    public static boolean check(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
