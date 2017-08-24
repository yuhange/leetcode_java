package leetcode.medium.array;

/**
 * Created by lenovo on 2017/8/24.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        int i = 0;
        int j = col - 1;
        while(i < row && j >= 0) {
            int cur = matrix[i][j];
            if(cur == target) return true;
            else if(cur < target) i ++;
            else j --;
        }
        return false;
    }
}
