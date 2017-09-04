/**
 * Created by lenovo on 2017/9/4.
 */
public class JustTest {

    int[][] maze;
    int m;
    int n;
    public int movingCount(int threshold, int rows, int cols)
    {
        m = rows;
        n = cols;
        maze = new int[rows][cols];
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                maze[i][j] = getSum(i, j);
            }
        }
        int count = dfs(0, 0, 0, threshold);
        return count;
    }

    private int dfs(int i, int j, int count, int k) {
        if(i < 0 || i >= m || j < 0 || j >= n) return count;
        if(maze[i][j] > k) return count;
        if(maze[i][j] == -1) return count;
        int tmp = maze[i][j];
        maze[i][j] = -1;
        int res = dfs(i+1, j, count+1, k) + dfs(i-1, j, count+1, k)
                + dfs(i, j+1, count+1, k) + dfs(i, j-1, count+1, k);
        maze[i][j] = tmp;
        return res;
    }

    private int getSum(int i, int j) {
        int sum = 0;
        while(i != 0) {
            sum += i%10;
            i /= 10;
        }
        while(j != 0) {
            sum += j%10;
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        JustTest jt = new JustTest();
        System.out.println(jt.movingCount(4, 4, 4));
    }
}
