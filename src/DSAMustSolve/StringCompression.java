package DSAMustSolve;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabbccccccaa";
        System.out.println(compressString(s));
    }

    public static String compressString (String s) {
        StringBuilder res = new StringBuilder();
        int count  = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                res.append(s.charAt(i)); // Append character first
                res.append(count); // Then count
                count = 1; // Reset count
            }
        }

        // Append the last character and its count
        res.append(s.charAt(s.length() - 1));
        res.append(count);
        return res.length() < s.length() ? res.toString() : s;
    }
}
