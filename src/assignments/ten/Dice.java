package assignments.ten;

import java.util.ArrayList;

//Amazon Question
//O(k power N), k -> k is the number of faces in a dice, N -> target number
//TODO - Revise before all the interview
public class Dice {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceRet("", 4));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> diceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i));
        }
        return list;
    }
}
