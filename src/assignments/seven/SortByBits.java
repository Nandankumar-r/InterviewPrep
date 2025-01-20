package assignments.seven;

import java.util.Arrays;
//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
public class SortByBits {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        //constant is chosen as is because the question tells the limit of the value inside the array,
        //0 <= arr[i] <= 10^4, hence we can choose any number > 10^4.
        //This is done to avoid getting clashes with already existing numbers after arr[i] + Integer.bitCount(arr[i])
        for(int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100003;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100003;
        }
        return arr;
    }
}
