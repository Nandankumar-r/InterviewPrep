package assignments.bitOperators;

//time complexity - log(n)
public class FindNumberOfDigits {
    public static void main(String[] args) {
        int n = 8978978;
        int base = 2;
        //why divide by log(base)?
        // java log function is natural log and baseLog = log(n)/log(base)
        int res = (int) (Math.log(n) / Math.log(base)) + 1;
        System.out.println(res);
    }
}
