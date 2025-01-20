package assignments.bitOperators;

public class FindUniqueElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(uniqueNumber(arr));

        int[] arr1 = {2,2,2,3,4,4,4,5,5,5};
        System.out.println(findSingleNumber(arr1));
    }

    public static int uniqueNumber(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static int findSingleNumber(int[] nums) {
        int[] bitCount = new int[32]; // To store count of bits for each position
        // Count the bits at each position
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        int result = 0;
        // Reconstruct the number that appears once
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
