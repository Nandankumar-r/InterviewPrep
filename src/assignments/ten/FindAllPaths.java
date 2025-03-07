package assignments.ten;

//Question: You are allowed to move only R & D in a matrix of size m * n
//You are at index (0,0) what are the different paths to reach index (m-1, n-1)
public class FindAllPaths {
    public static void main(String[] args) {
        findAllPaths("", 3, 3);
    }

    public static void findAllPaths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1)
            findAllPaths(p + 'D', r - 1, c);

        if (c > 1)
            findAllPaths(p + 'R', r, c - 1);
    }
}
