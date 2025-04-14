package leetcodeDaily;

//Leetcode 3208
public class AlternatingGroups {
    public static void main(String[] args) {
        int[] colours = {0,1,0,1,0};
        int k = 3;
        AlternatingGroups obj = new AlternatingGroups();
        System.out.println(obj.numberOfAlternatingGroups(colours, k));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int left = 0, res = 0;

        //loop starts from 1 and goes till n + (k - 1) because, the array according to the problem is cyclic
        // and there will be (k - 1) extra windows which we have to check before getting duplicate windows
        for (int right = 1; right < n + (k - 1); right++) {
            if (colors[right % n] == colors[(right - 1) % n]) {
                left = right;
            }
            if (right - left + 1 > k) {
                left += 1;
            }
            if (right - left + 1 == k) {
                res += 1;
            }
        }
        return res;
    }
}
