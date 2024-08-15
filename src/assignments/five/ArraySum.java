package assignments.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraySum {
    public static void main(String[] args) {
        int[] index = {9,9,9,9,9,9,9,9,9,9};
        List<Integer> res = addToArrayForm(index, 1);
        System.out.println(res);
    }

    public static List<Integer> addToArrayForm(int[] num, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            res.add(0, (num[i] + K) % 10);
            K = (num[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
