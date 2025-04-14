package DSAMustSolve;

import java.util.ArrayList;
import java.util.List;

public class ParanthesisGenerator {
    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        paranthesisHelper(n, sb, res, 0, 0);
        return res;
    }

    public static void paranthesisHelper(int n, StringBuilder sb, List<String> res, int open, int close) {
        if(open > n || close > open)
            return;

        if(open + close == n * 2) {
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            paranthesisHelper(n, sb, res, open + 1, close);
            sb.delete(sb.length() - 1, sb.length());
        }
        if(close < open) {
            sb.append(")");
            paranthesisHelper(n, sb, res, open, close + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
