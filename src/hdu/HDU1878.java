package hdu;
import java.util.*;
/**
   欧拉回路是指不令笔离开纸面，可画过图中每条边仅一次，且可以回到起点的一条回路。现给定一个图，问是否存在欧拉回路？
输入描述:测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是节点数N ( 1 < N < 1000 )和边数M；随后的M行对应M条边，每行给出一对正整数，分别是该条边直接连通的两个节点的编号（节点从1到N编号）。当N为0时输入结束。
输出描述:每个测试用例的输出占一行，若欧拉回路存在则输出1，否则输出0。
示例1
输入
3 3
1 2
1 3
2 3
3 2
1 2
2 3
0
输出
1
0
* */
public class HDU1878 {
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            int m = scanner.nextInt();
            int[][] edges = new int[n+1][n+1];
            int[] nodes = new int[n+1];
            visited = new boolean[n+1];
            for(int i = 0; i<m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                nodes[x] ++;
                nodes[y] ++;
                edges[x][y] = 1;
                edges[y][x] = 1;
            }
            // 判断每个点的度是否都是偶数，如果不是，肯定不存在欧拉回路回。
            // 判断连通性。判断依据：存在一个点，从这个点触发可以遍历到达其他所有点。
            dfs(edges, 1, n);
            boolean exists = true;
            for(int i = 1; i<=n; i++) {
//System.out.println(visited[i]);
                if(visited[i] != true || nodes[i]%2 == 1) {
                    exists = false;
                    break;
                }
            }
            if(exists == true) System.out.println(1);
            else System.out.println(0);
        }
    }

    public static void dfs(int[][] edges, int start, int n) {
        visited[start] = true;
        for(int i = 1; i<=n; i++) {
            if(visited[i] != true && edges[start][i] == 1) {
                dfs(edges, i, n);
                break; // 为什么要break?
            }
        }
    }
}