package assignments.five;

import java.util.ArrayList;
import java.util.List;

public class MatchingRule {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(List.of(new String[]{"phone", "blue", "pixel"}));
        items.add(List.of(new String[]{"computer","silver","lenovo"}));
        items.add(List.of(new String[]{"phone","silver","iphone"}));
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey,ruleValue));
    }

    /*
    Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
    Output: 1
     */
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int valueToCheck = -1;
        int res = 0;
        if ("type".equals(ruleKey)) {
            valueToCheck = 0;
        } else if ("color".equals(ruleKey)) {
            valueToCheck = 1;
        } else {
            valueToCheck = 2;
        }

        for (List<String> item : items) {
            if (ruleValue.equals(item.get(valueToCheck)))
                res++;
        }
        return res;
    }
}
