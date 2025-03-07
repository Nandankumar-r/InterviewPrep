package assignments.ten.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberToMsg {
    public static final HashMap<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public static void main(String[] args) {
        PhoneNumberToMsg msg = new PhoneNumberToMsg();
        System.out.println(msg.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        return backtrack(0, "", digits, res);

    }
    public List<String> backtrack(int i, String currString, String digits, List<String> res) {
        if (currString.length() == digits.length()) {
            res.add(currString);
            return res;
        }
        String eqString = map.get(digits.charAt(i));
        for (Character c : eqString.toCharArray()) {
            backtrack(i + 1, currString + c, digits, res);
        }
        return res;
    }
}
