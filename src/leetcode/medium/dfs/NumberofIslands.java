package leetcode.medium.dfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
    }
}
