/**
 * Created by lenovo on 2017/3/17.
 */
public class Sudo {

    static int[][] sudo = {
            {3,0,6,0,5,7,0,0,0},
            {7,9,0,0,2,4,0,0,0},
            {0,5,0,6,0,0,9,7,4},
            {8,0,1,0,0,9,0,0,0},
            {0,2,0,3,0,8,0,0,7},
            {4,0,0,0,6,0,5,0,0},
            {0,0,4,0,3,6,0,5,0},
            {2,0,3,7,0,5,0,0,1},
            {0,0,7,4,1,0,6,0,0}};

    public static void solve() {
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(sudo[i][j] == 0) {
                    for(int k = 1; k<=9; k++) {
                        if(help(i, j, k)) sudo[i][j] = k;
                    }
                }
            }
        }
    }

    public static boolean help(int i, int j, int k) {
        int m = i/3;
        int n = j/3;
        for(int p = 0; p<9; p++) {
            if(k == sudo[p][i]) return false;
            if(k == sudo[j][p]) return false;
            if(k == sudo[3*m + p/3][3*n+p%3]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solve();
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                System.out.print(sudo[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
