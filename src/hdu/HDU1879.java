package hdu;

import java.util.*;
/**
 * Problem Description
 省政府“畅通工程”的目标是使全省任何两个村庄间都可以实现公路交通（但不一定有直接的公路相连，只要能间接通过公路可达即可）。现得到城镇道路统计表，表中列出了任意两城镇间修建道路的费用，以及该道路是否已经修通的状态。现请你编写程序，计算出全省畅通需要的最低成本。


 Input
 测试输入包含若干测试用例。每个测试用例的第1行给出村庄数目N ( 1< N < 100 )；随后的 N(N-1)/2 行对应村庄间道路的成本及修建状态，每行给4个正整数，分别是两个村庄的编号（从1编号到N），此两村庄间道路的成本，以及修建状态：1表示已建，0表示未建。

 当N为0时输入结束。


 Output
 每个测试用例的输出占一行，输出全省畅通需要的最低成本。


 Sample Input
 3
 1 2 1 0
 1 3 2 0
 2 3 4 0
 3
 1 2 1 0
 1 3 2 0
 2 3 4 1
 3
 1 2 1 0
 1 3 2 1
 2 3 4 1
 0


 Sample Output
 3
 1
 0

 */
public class HDU1879 {
    static int[] p;
    static int count = 0;
    static PriorityQueue<Node> edges = new PriorityQueue<Node>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt(); // 村庄数目
            if(n == 0) return;
            int m = n*(n-1)/2; // 道路数目
            p = new int[105];
            init();
            int sum = 0;
            for(int i = 0; i<m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int cost = scanner.nextInt();
                int has = scanner.nextInt();
                if (has == 1) {
                    if (find(x) != find(y)) {
                        union(x, y);
                    }
                } else {
                    edges.offer(new Node(x, y, cost));
                }
            }
            int count = 0;
            while(!edges.isEmpty()) {
                Node e = edges.poll();
                if(find(e.u) != find(e.v)) {
                    union(e.u, e.v);
                    sum += e.cost;
                    count ++;
                }
                if(count == n - 1) {
                    break;
                }
            }
            System.out.println(sum);
        }
    }

    private static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if(X != Y) {
            p[X] = p[Y];
        }
    }

    private static void init() {
        for(int i = 0; i<105; i++) p[i] = i;
        count = 0;
    }

    private static int find(int x) {
        while(p[x] != x) {
            x = p[x];
        }
        return x;
    }
}
