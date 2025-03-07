package assignments.ten;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode code = new GrayCode();
        System.out.println(code.grayCode(3));
    }

    //O(n*2^n)
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        res.add(0);
        seen.add(0);

        generateGrayCode(n, res, seen);
        return res;
    }

    private boolean generateGrayCode(int n, List<Integer> res, HashSet<Integer> seen) {
        if (res.size() == (1 << n)) {
            return true;
        }

        int lastNum = res.get(res.size() - 1);
        for (int k = 0; k < n; k++) {
            int nextNum = lastNum ^ (1 << k);
            if (!seen.contains(nextNum)) {
                seen.add(nextNum);
                res.add(nextNum);

                if (generateGrayCode(n, res, seen)) {
                    return true;
                }
                seen.remove(nextNum);
                res.remove(res.size() - 1);
            }
        }
        return false;
    }


    //O(2^n)
    public List<Integer> grayCodeDP(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0); // Start with base case n = 0 -> [0]

        for (int i = 0; i < n; i++) {
            int size = res.size();
            int prefix = 1 << i; // 2^i to add a 1-bit prefix
            for (int j = size - 1; j >= 0; j--) { // Mirror existing sequence
                //Mirroring means that we take the existing Gray Code sequence, reverse it, and prefix it with a 1
                res.add(prefix | res.get(j)); // Prefix with 1
            }
        }
        return res;
    }
}
