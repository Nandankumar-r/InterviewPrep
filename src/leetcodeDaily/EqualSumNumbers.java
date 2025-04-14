package leetcodeDaily;

public class EqualSumNumbers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            if (num.length() % 2 == 1) continue;
            count += getDigitSum(num);
        }
        return count;
    }

    public int getDigitSum(String num) {
        int l = 0, r = num.length() - 1;
        int sumL = 0, sumR = 0;
        while (l < r) {
            sumL += Integer.valueOf(num.charAt(l++));
            sumR += Integer.valueOf(num.charAt(r--));
        }
        return sumL == sumR ? 1 : 0;
    }
}
