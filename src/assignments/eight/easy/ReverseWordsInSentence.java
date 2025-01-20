package assignments.eight.easy;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
        System.out.println("s'teL ekat edoCteeL tsetnoc");
    }

    public static String reverseWords(String s) {
        String[] stringArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : stringArray) {
            char[] charArray = word.toCharArray();
            for (int i = charArray.length - 1; i >= 0; i--) {
                sb.append(charArray[i]);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseWordsV2(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String c: arr){
            res.append(new StringBuilder(c).reverse().append(" "));
        }
        return res.toString().trim();
    }
}
