package assignments.five;

import java.util.Arrays;

public class FlipInvertImage {
    public static void main(String[] args) {
        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] res = flipAndInvertImage(image);
        System.out.println(Arrays.deepToString(res));
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] imageRow : image)
            reverseAndInvert(imageRow);
        return image;
    }

    public static void reverseAndInvert(int[] imageRow) {
        int start = 0;
        int end = imageRow.length - 1;
        while (start < end) {
            int temp = imageRow[start];
            imageRow[start] = imageRow[end];
            imageRow[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < imageRow.length; i++) {
            if (imageRow[i] == 0) {
                imageRow[i] = 1;
            } else {
                imageRow[i] = 0;
            }
        }
    }
}
