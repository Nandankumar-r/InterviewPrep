package assignments.five;

import java.util.ArrayList;
import java.util.List;

//TODO - redo https://leetcode.com/problems/lucky-numbers-in-a-matrix/
public class LuckyMatrix {
    public static void main(String[] args) {
        int[][] matrix ={
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        List<Integer> res = luckyNumbers(matrix);
        System.out.println(res);
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxOfRowMins = Integer.MIN_VALUE;
        for(int i =0;i<rows;i++){
            int minVals = matrix[i][0];
            for(int j =0;j<cols;j++){
                minVals = Math.min(minVals,matrix[i][j]);
            }
            maxOfRowMins = Math.max(minVals, maxOfRowMins);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<cols;i++){
            int maxVals = matrix[0][i];
            for(int j =0;j<rows;j++){
                maxVals = Math.max(maxVals,matrix[j][i]);
            }
            if(maxVals == maxOfRowMins){
                res.add(maxVals);
                return res;
            }
        }
        return res;

    }
}
