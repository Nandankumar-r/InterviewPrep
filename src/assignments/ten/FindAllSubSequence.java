package assignments.ten;

import java.util.ArrayList;
import java.util.Collections;

public class FindAllSubSequence {
    public static void main(String[] args) {
        //findAllSubSequence("", "abc");
        System.out.println(findAllSubSequenceReturn("", "abc"));
    }

    public static void findAllSubSequence(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        findAllSubSequence(p + c, up.substring(1));
        findAllSubSequence(p, up.substring(1));
    }

    public static ArrayList<String> findAllSubSequenceReturn(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        ArrayList<String> left = findAllSubSequenceReturn(p + c, up.substring(1));
        ArrayList<String> right = findAllSubSequenceReturn(p, up.substring(1));
        left.addAll(right);
        left.removeAll(Collections.singleton(""));
        return left;
    }
}
