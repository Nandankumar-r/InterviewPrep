package assignments.ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class ComputeExpression {
    private static final HashMap<Character, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();
    static {
        operator.put('+', (a, b) -> (a + b));
        operator.put('-', (a, b) -> (a - b));
        operator.put('*', (a, b) -> (a * b));
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        ComputeExpression ce = new ComputeExpression();
        System.out.println(ce.diffWaysToCompute(expression));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int left = 0;
        int right = expression.length() - 1;
        return backtrack(expression, left, right);
    }

    // Method to perform operation based on the operator
    public int compute(Character op, int num1, int num2) {
        return operator.getOrDefault(op, (a, b) -> 0).apply(num1, num2);
    }


    public List<Integer> backtrack(String expression, int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            Character op = expression.charAt(i);
            if (operator.containsKey(op)) {
                List<Integer> leftRes = backtrack(expression, left, i - 1);
                List<Integer> rightRes = backtrack(expression, i + 1, right);

                for (Integer n1 : leftRes) {
                    for (Integer n2 : rightRes) {
                        res.add(compute(op, n1, n2));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression.substring(left, right + 1)));
        }
        return res;
    }
}
