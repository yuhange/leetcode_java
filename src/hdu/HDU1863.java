package hdu;

import java.util.*;

/**
 * Problem Description
 省政府“畅通工程”的目标是使全省任何两个村庄间都可以实现公路交通（但不一定有直接的公路相连，只要能间接通过公路可达即可）。经过调查评估，得到的统计表中列出了有可能建设公路的若干条道路的成本。现请你编写程序，计算出全省畅通需要的最低成本。


 Input
 测试输入包含若干测试用例。每个测试用例的第1行给出评估的道路条数 N、村庄数目M ( < 100 )；随后的 N
 行对应村庄间道路的成本，每行给出一对正整数，分别是两个村庄的编号，以及此两村庄间道路的成本（也是正整数）。为简单起见，村庄从1到M编号。当N为0时，全部输入结束，相应的结果不要输出。


 Output
 对每个测试用例，在1行里输出全省畅通需要的最低成本。若统计数据不足以保证畅通，则输出“?”。


 Sample Input
 3 3
 1 2 1
 1 3 2
 2 3 4
 1 3
 2 3 2
 0 100


 Sample Output
 3
 ?
 */
public class HDU1863 {
    static int[] p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node[] nodes;
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            int m = scanner.nextInt();
            nodes = new Node[n];
            p = new int[105];
            init();
            int sum = 0;
            for(int i = 0; i<n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int cost = scanner.nextInt();
                nodes[i] = new Node(x, y, cost);
            }
            Arrays.sort(nodes);
            for(int i = 0; i<n; i++) {
                if(find(nodes[i].u) != find(nodes[i].v)) {
                    union(nodes[i].u, nodes[i].v);
                    sum += nodes[i].cost;
                }
            }
            int num = 0;
            for(int i = 1; i<=m; i++) {
                if(p[i] == i) num ++;
            }
            if(num == 1)
                System.out.println(sum);
            else
                System.out.println("?");
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
    }

    private static int find(int x) {
        while(p[x] != x) {
            x = p[x];
        }
        return x;
    }
}
