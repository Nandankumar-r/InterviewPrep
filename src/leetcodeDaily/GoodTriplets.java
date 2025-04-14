package leetcodeDaily;

public class GoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int n = arr.length;
        int[] prefixCnt = new int[1001];
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int r = Math.min(arr[j] + a, arr[k] + c);
                    int l = Math.max(arr[j] - a, arr[k] - c);
                    l = Math.max(l, 0);
                    r = Math.min(r, 1000);

                    if (l <= r)
                        res += prefixCnt[r] - (l - 1 < 0 ? 0 : prefixCnt[l - 1]);
                }
            }
            for (int index = arr[j]; index < 1001; index++)
                prefixCnt[index] += 1;
        }

        return res;
    }
}
