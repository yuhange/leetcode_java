package hdu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description
 某省调查乡村交通状况，得到的统计表中列出了任意两村庄间的距离。省政府“畅通工程”的目标是使全省任何两个村庄间都可以实现公路交通（但不一定有直接的公路相连，只要能间接通过公路可达即可），并要求铺设的公路总长度为最小。请计算最小的公路总长度。


 Input
 测试输入包含若干测试用例。每个测试用例的第1行给出村庄数目N ( < 100 )；随后的N(N-1)/2行对应村庄间的距离，每行给出一对正整数，分别是两个村庄的编号，以及此两村庄间的距离。为简单起见，村庄从1到N编号。
 当N为0时，输入结束，该用例不被处理。


 Output
 对每个测试用例，在1行里输出最小的公路总长度。


 Sample Input
 3
 1 2 1
 1 3 2
 2 3 4
 4
 1 2 1
 1 3 4
 1 4 1
 2 3 3
 2 4 2
 3 4 5
 0


 Sample Output
 3
 5
 */
public class HDU1233 {
    static int[] p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node[] nodes;
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            int m = n*(n-1)/2;
            nodes = new Node[m];
            p = new int[105];
            init();
            int sum = 0;
            for(int i = 0; i<m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int cost = scanner.nextInt();
                nodes[i] = new Node(x, y, cost);
            }
            Arrays.sort(nodes);
            int count = 0;
            for(int i = 0; i<m; i++) {
                if(find(nodes[i].u) != find(nodes[i].v)) {
                    union(nodes[i].u, nodes[i].v);
                    sum += nodes[i].cost;
                }
                if(count >= n - 1) {
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
    }

    private static int find(int x) {
        while(p[x] != x) {
            x = p[x];
        }
        return x;
    }
}

class Node implements Comparable<Node>{
    int u;
    int v;
    int cost;
    public Node(int u, int v, int cost){
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
