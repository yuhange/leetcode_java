package leetcode.medium.array;

/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class RotateImage {
    public void rotate(int[][] a) {
        int n = a.length;
        if(n == 0) return;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n/2; j++) {
                int tmp = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = tmp;
            }
        }
    }
}
