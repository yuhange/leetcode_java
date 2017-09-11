package leetcode.medium.broadfirstsearch;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
import java.util.*;
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null) return;
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        if(col == 0) return;

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        bfs(board, i, j, row, col);
                    }
                }
            }
        }

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int i, int j, int row, int col) {
        Queue<Point> q = new LinkedList<Point>();
        board[i][j] = '*';
        q.offer(new Point(i, j));
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x > 0 && board[x - 1][y] == 'O') {
                q.offer(new Point(x - 1, y));
                board[x-1][y] = '*';
            }
            if(x < row - 1 && board[x + 1][y] == 'O') {
                q.offer(new Point(x + 1, y));
                board[x+1][y] = '*';
            }
            if(y > 0 && board[x][y - 1] == 'O') {
                q.offer(new Point(x, y - 1));
                board[x][y-1] = '*';
            }
            if(y < col - 1 && board[x][y + 1] == 'O') {
                q.offer(new Point(x, y + 1));
                board[x][y+1] = '*';
            }
        }
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
