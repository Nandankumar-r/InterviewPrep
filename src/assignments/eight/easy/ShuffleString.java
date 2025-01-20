package assignments.eight.easy;

public class ShuffleString {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(restoreStringV2(s, indices));
    }

    //count sort
    public static String restoreString(String s, int[] indices) {
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            while (i != indices[i]) {
                swapChar(cArr, i, indices[i]);
                swapInt(indices, i, indices[i]);
            }
        }
        return String.valueOf(cArr);
    }

    public static void swapInt(int[] indices, int x, int y) {
        int temp = indices[x];
        indices[x] = indices[y];
        indices[y] = temp;
    }

    public static void swapChar(char[] cArr, int x, int y) {
        char t = cArr[x];
        cArr[x] = cArr[y];
        cArr[y] = t;
    }

    //or

    public static String restoreStringV2(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++){
            ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
    }
}
