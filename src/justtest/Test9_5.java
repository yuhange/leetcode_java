package justtest;

/**
 * Created by lenovo on 2017/9/5.
 */
public class Test9_5 {
    char[][] maze;
    int n;
    int m;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        n = rows;
        m = cols;
        if(n * m != matrix.length) return false;
        maze = new char[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                maze[i][j] = matrix[m*i + j];
            }
        }
        String s = new String(str);
//        System.out.println(s);
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(maze[i][j] == str[0]) {
                    if(dfs(i, j, s)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String s) {
//        System.out.println(s);
        if(s.length() == 0) return true;
        if(i<0 || i>=n || j<0 || j>=m) return false;
        if(s.charAt(0) != maze[i][j]) return false;
        if(maze[i][j] == '.') return false;
        if(s.length() < 0) return false;
        if(maze[i][j] == s.charAt(0)) {
            s = s.substring(1);
            char c = maze[i][j];
            maze[i][j] = '.';
            boolean res = dfs(i+1, j, s) || dfs(i, j+1, s) || dfs(i-1, j, s) || dfs(i, j-1, s);
            maze[i][j] = c;
            return res;
        }
        return false;
    }
    // "ABCESFCSADEE",3,4,"ABCCED"
    public static void main(String[] args) {
        Test9_5 test = new Test9_5();
        System.out.println(test.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }
}
