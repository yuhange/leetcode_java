package wangyi;

/**
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。假设市区是一个无限大的区域，每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，另外一种就是走到一个出租车打车点，然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，打车将花费taxiTime时间。小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。
 输入描述:
 输入数据包括五行:
 第一行为周围出租车打车点的个数n(1 ≤ n ≤ 50)
 第二行为每个出租车打车点的横坐标tX[i] (-10000 ≤ tX[i] ≤ 10000)
 第三行为每个出租车打车点的纵坐标tY[i] (-10000 ≤ tY[i] ≤ 10000)
 第四行为办公室坐标gx,gy(-10000 ≤ gx,gy ≤ 10000),以空格分隔
 第五行为走路时间walkTime(1 ≤ walkTime ≤ 1000)和taxiTime(1 ≤ taxiTime ≤ 1000),以空格分隔

 */
import java.util.*;
public class BackToOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] taxi = new int[n][2];
        for(int i = 0; i<n; i++) {
            taxi[i][0] = scanner.nextInt();
        }
        for(int i = 0; i<n; i++) {
            taxi[i][1] = scanner.nextInt();
        }
        int officeX = scanner.nextInt();
        int officeY = scanner.nextInt();
        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();
        int directWalk = walkTime * (Math.abs(officeX) + Math.abs(officeY));
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            int walkToTaxiI = walkTime * (Math.abs(taxi[i][0]) + Math.abs(taxi[i][1]));
            int taxiIToOffice = taxiTime * (Math.abs(taxi[i][0] - officeX) +
                    Math.abs(taxi[i][1] - officeY));
            min = Math.min(min, walkToTaxiI + taxiIToOffice);
        }
        min = Math.min(min, directWalk);
        System.out.println(min);
    }
}
