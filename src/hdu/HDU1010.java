package hdu;

/**
 * Problem Description
 The doggie found a bone in an ancient maze, which fascinated him a lot. However, when he picked it up, the maze began to shake, and the doggie could feel the ground sinking. He realized that the bone was a trap, and he tried desperately to get out of this maze.

 The maze was a rectangle with sizes N by M. There was a door in the maze. At the beginning, the door was closed and it would open at the T-th second for a short period of time (less than 1 second). Therefore the doggie had to arrive at the door on exactly the T-th second. In every second, he could move one block to one of the upper, lower, left and right neighboring blocks. Once he entered a block, the ground of this block would start to sink and disappear in the next second. He could not stay at one block for more than one second, nor could he move into a visited block. Can the poor doggie survive? Please help him.


 Input
 The input consists of multiple test cases. The first line of each test case contains three integers N, M, and T (1 < N, M < 7; 0 < T < 50), which denote the sizes of the maze and the time at which the door will open, respectively. The next N lines give the maze layout, with each line containing M characters. A character is one of the following:

 'X': a block of wall, which the doggie cannot enter;
 'S': the start point of the doggie;
 'D': the Door; or
 '.': an empty block.

 The input is terminated with three 0's. This test case is not to be processed.


 Output
 For each test case, print in one line "YES" if the doggie can survive, or "NO" otherwise.


 Sample Input
 4 4 5
 S.X.
 ..X.
 ..XD
 ....
 3 4 5
 S.X.
 ..X.
 ...D
 0 0 0


 Sample Output
 NO
 YES
 */
import java.util.*;
public class HDU1010 {
    static int count = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] t = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean flag = false;
    static int endX;
    static int endY;
    static int row, col, time;
    static char[][] maze;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            count = Integer.MAX_VALUE;
            row = scanner.nextInt();
            if(row == 0) return;
            col = scanner.nextInt();
            time = scanner.nextInt();
            maze = new char[row][col];
            visited = new boolean[row][col];
            int startX = 0;
            int startY = 0;
            int walls = 0;
            for(int i = 0; i<row; i++) {
                String curRow = scanner.next();
                for(int j = 0; j<col; j++) {
                    maze[i][j] = curRow.charAt(j);
                    if(maze[i][j] == 'S') {
                        startX = i;
                        startY = j;
                    }
                    if(maze[i][j] == 'D') {
                        endX = i;
                        endY = j;
                    }
                    if(maze[i][j] == 'X') {
                        walls ++;
                    }
                }
            }
            if(row * col - walls <= time) {
                System.out.println("NO");
                continue;
            }
            visited[startX][startY] = true;
            flag = false;
            dfs(startX, startY, 0);
            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int startX, int startY,
             int cnt) {
        if(startX == endX && startY == endY && cnt == time) {
            flag = true;
            return;
        }
        if(flag) return;
        int tmp = (time - cnt) - (Math.abs(startX - endX) + Math.abs(startY - endY));
        if(tmp < 0 || (tmp & 1) != 0) {
            return;
        }
        for(int i = 0; i<4; i++) {
            startX = startX + t[i][0];
            startY = startY + t[i][1];
            if(startX >= 0 && startX < row && startY >= 0 && startY < col
                    && maze[startX][startY] != 'X' &&
                    visited[startX][startY] == false) {
                visited[startX][startY] = true;
                dfs(startX, startY, cnt + 1);
                visited[startX][startY] = false;
            }
        }
    }
}
