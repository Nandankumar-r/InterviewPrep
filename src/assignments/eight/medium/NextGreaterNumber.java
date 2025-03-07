package assignments.eight.medium;

import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-iii/description/
public class NextGreaterNumber {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(124651));
    }

    public static int nextGreaterElement(int n) {
        char[] charNum = (n + "").toCharArray();
        int i,j;
        //find the digit in n such that it is smaller than the digit next to it
        for (i = charNum.length - 1; i > 0; i--) {
            if (charNum[i - 1] < charNum[i]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        
        int x = charNum[i - 1], smallest = i;
        //find the smallest digit greater than x after x in the array
        for (j = i + 1; j < charNum.length; j++) {
            if (charNum[j] > x && charNum[j] <= charNum[smallest]) {
                smallest = j;
            }
        }
        //swap i & smallest
        char temp = charNum[i - 1];
        charNum[i - 1] = charNum[smallest];
        charNum[smallest] = temp;

        //sorting is required because it will make sure that the number is the smallest
        Arrays.sort(charNum, i, charNum.length);
        long res = Long.parseLong(new String(charNum));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}
