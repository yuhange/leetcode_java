package hdu;

/**
 * 符号三角形的 第1行有n个由“+”和”-“组成的符号 ，以后每行符号比上行少1个，2个同号下面是”+“，2个异 号下面是”-“ 。计算有多少个不同的符号三角形，使其所含”+“ 和”-“ 的个数相同 。 n=7时的1个符号三角形如下:
 + + - + - + +
 + - - - - +
 - + + + -
 - + + -
 - + -
 - -
 +

 */
import java.util.*;
public class HDU2510 {
    static int t[][] = new int[30][30];
    static int p[] = new int[30];
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] res = {0,0,4,6,0,0,12,40,0,0,171,410,0,0,1896,5160,0,0,32757,59984,0,0,431095,822229};
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
//            count = 0;
//            dfs(1);
//        for(int i = 0; i<25; i++) System.out.println(p[i]);
            System.out.println(n + " " + res[n - 1]);
        }
    }

    private static void dfs(int n) {
        if(n > 25) return; // 第一行超过25个字符了，就退出
        for(int i = 0; i<2; i++) { // 设+为0，-为1
            t[1][n] = i; // 第一行的第n个字符
            count += i; // count用来统计1的个数，即-的个数

            // 如果n已经超过2，可以向下生成第2行，第三行……，边生成，边统计-的个数
            for(int j = 2; j<=n; j++) {
                t[j][n - j + 1] = t[j - 1][n - j + 1] ^ t[j - 1][n - j + 2]; // 用异或简化操作
                count += t[j][n - j + 1];
            }

            if(count*2 == n*(n+1)/2) p[n] ++;
            dfs(n + 1);

            // 回溯，即出栈操作，恢复count
            for(int j = 2; j<=n; j++) {
                t[j][n - j + 1] = t[j - 1][n - j + 1] ^ t[j - 1][n - j + 2]; // 用异或简化操作
                count -= t[j][n - j + 1];
            }
            count -= i;
        }
    }
}
