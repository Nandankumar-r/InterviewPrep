package algorithms.searching;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        int res = linearSearch(arr, 10);
        System.out.println(res);

        int[][] array2D = new int[][] {
                {1, 2, 3, 4},
                {12, 54, 13, 35, 43},
                {23, 76, 235}
        };
        int[] result = linearSearch(array2D, 433);
        System.out.println(Arrays.toString(result));
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int[] linearSearch(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
