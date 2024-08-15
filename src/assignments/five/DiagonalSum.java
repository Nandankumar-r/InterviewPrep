package assignments.five;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] image = {
                {0,1,3},
                {1,1,5},
                {2,4,6}
        };
        int res = diagonalSum(image);
        System.out.println(res);
    }
    public static int diagonalSum(int[][] mat) {
        int m = mat.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    sum += mat[i][j];
                }
            }
        }
        int i = 0;
        int j = mat.length - 1;
        for (int x = 0; x < mat.length; x++) {
            if (i != j) {
                sum += mat[i][j];
            }
            i++;
            j--;
        }

        return sum;
    }

    /*
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=mat[i][i] + mat[i][n-1-i];
        }
        if(n%2==1){
            sum=sum-mat[n/2][n/2];
        }
        return sum;
    }
     */

}
