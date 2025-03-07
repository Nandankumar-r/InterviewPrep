package assignments.ten;

public class FindAllPathsWithRiver {
    public static void main(String[] args) {
        //false represents a river in that cell
        boolean[][] riverMatrix = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        findAllPathsWithRiver("", riverMatrix, 0 , 0);
    }

    public static void findAllPathsWithRiver(String p, boolean[][] riverMatrix, int r, int c) {
        if (r == riverMatrix.length - 1 && c == riverMatrix[0].length - 1) {
            System.out.println(p);
            return;
        }

        //Return when you encounter a river
        if (!riverMatrix[r][c]) {
            return;
        }

        if (r < riverMatrix.length - 1)
            findAllPathsWithRiver(p + "D", riverMatrix, r+1, c);

        if (c < riverMatrix[0].length - 1)
            findAllPathsWithRiver(p + "R", riverMatrix, r, c+1);
    }
}
