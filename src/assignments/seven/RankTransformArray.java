package assignments.seven;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/rank-transform-of-an-array/description/
public class RankTransformArray {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12,12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
    public static int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        Arrays.sort(arrCopy);

        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : arrCopy)
            rank.putIfAbsent(x, rank.size() + 1);

        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = rank.get(arr[i]);
        }
        return arrCopy;
    }
}
