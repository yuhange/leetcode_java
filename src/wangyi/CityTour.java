package wangyi;

/**
 * Created by lenovo on 2017/9/9.
 */
import java.util.*;
public class CityTour {
    static int[][] edges;
    static boolean[][] v;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 城市数
        int k = scanner.nextInt(); // 移动数
        edges = new int[n][n];
        for(int i = 0; i<n-1; i++) {
            int tmp = scanner.nextInt();
            edges[tmp][tmp+1] = 1;
            edges[tmp+1][tmp] = 1;
        }
        int max = 0;
        for(int i = 0; i<n; i++) {
            v = new boolean[n][n];
            count = 0;
            dfs(i, n, k);
            max = Math.max(count, max);
        }
        System.out.println(max + 1);
    }

    private static void dfs(int startX, int n, int k) {
//        System.out.println(startX + " " + k);
        if(k == 0) return; // 已经移动完;
        if(k < 0) return;
        for(int i = startX; i<n; i++) {
            if(startX != i && edges[startX][i] == 1 && v[startX][i] != true) {
//                System.out.println(startX + " " + i);
                v[startX][i] = true;
                edges[startX][i] = 0;
                edges[i][startX] = 0;
                count ++;
                dfs(i, n, k - 1);
                v[startX][i] = false;
                edges[startX][i] = 1;
                edges[i][startX] = 1;
            }
        }
    }
}
