package leetcode.medium.dfs;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row == 0) return false;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, board, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, char[][] board, String word) {
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || index > word.length() || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] ^= 128;
        index ++;
        boolean flag = dfs(i + 1, j, index, board, word) ||
                dfs(i, j + 1, index, board, word) ||
                dfs(i - 1, j, index, board, word) ||
                dfs(i, j - 1, index, board, word);
        board[i][j] ^= 128;
        return flag;
    }
}
