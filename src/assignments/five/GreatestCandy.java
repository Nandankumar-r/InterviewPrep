package assignments.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCandy {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        List<Boolean> res = kidsWithCandies(nums, n);
        System.out.println(res);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int largest = candies[0];
        for (int candy : candies) {
            if (candy > largest)
                largest = candy;
        }
        for (int candy : candies) {
            if (candy + extraCandies >= largest) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
