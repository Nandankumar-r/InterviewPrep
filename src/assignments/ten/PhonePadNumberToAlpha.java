package assignments.ten;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

//Google Question
//O(k power N), k -> k is the average number of letters per digit
//TODO - Revise before all the interview
public class PhonePadNumberToAlpha {
    public static void main(String[] args) {
        //phonePadNumberToMsg("", "12");
        //System.out.println(phonePadNumberToMsgRet("", "12"));
        //System.out.println(phonePadNumberToMsgCount("", "12"));
        System.out.println(letterCombinations("45"));
    }

    public static void phonePadNumberToMsg(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int n = up.charAt(0) - '0'; //Formula to convert character number to int
        for (int i = (n - 1) * 3; i < n * 3; i++) {
            char ch = (char) ('a' + i);
            phonePadNumberToMsg(p + ch, up.substring(1));
        }
    }


    public static ArrayList<String> phonePadNumberToMsgRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int n = up.charAt(0) - '0'; //Formula to convert character number to int
        ArrayList<String> res = new ArrayList<>();
        for (int i = (n - 1) * 3; i < n * 3; i++) {
            char ch = (char) ('a' + i);
            res.addAll(phonePadNumberToMsgRet(p + ch, up.substring(1)));
        }
        return res;
    }

    public static int phonePadNumberToMsgCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int n = up.charAt(0) - '0'; //Formula to convert character number to int
        int res = 0;
        for (int i = (n - 1) * 3; i < n * 3; i++) {
            char ch = (char) ('a' + i);
            res += phonePadNumberToMsgCount(p + ch, up.substring(1));
        }
        return res;
    }


    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        return numberToletter("", digits);
    }

    public static List<String> numberToletter(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        int n = up.charAt(0) - '0';
        if (n >= 2 && n <= 6) {
            start = (n - 2) * 3;
            end = (n - 1) * 3;
        } else if (n == 7) {
            start = 15;
            end = 19;
        } else if (n == 8) {
            start = 19;
            end = 22;
        } else if (n == 9) {
            start = 22;
            end = 26;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            res.addAll(numberToletter(p + ch, up.substring(1)));
        }
        return res;
    }

}
