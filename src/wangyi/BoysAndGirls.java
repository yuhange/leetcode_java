package wangyi;

/**
 * Created by lenovo on 2017/9/9.
 */
import java.util.*;
public class BoysAndGirls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] c = s.toCharArray();
        int n = s.length();
        if(n == 0 || n == 1) {
            System.out.println(0);
            return;
        }
        int count1 = 0;
        int count2 = 0;
        int girl = 0; // 连续女生结束的标识
        int boy = 0; // 连续男生结束的标识
            while(girl < n && boy < n) {
                while(girl < n && c[girl] == 'G') girl ++;
                girl --;
                boy = girl + 1;
//            System.out.println("girl:" + girl);
                while(boy < n && c[boy] == 'B') boy ++;
                if(boy == n) break;
                boy --;
//            System.out.println("boy:" + boy);
                if(c[boy + 1] == 'G') {
                    count1 += (boy - girl);
                    char t = c[girl + 1];
                    c[girl + 1] = c[boy + 1];
                    c[boy + 1] = t;
                    girl ++;
                }
            }
            boy = 0;
            girl = 0;
            while(girl < n && boy < n) {
                while(boy < n && c[boy] == 'B') boy ++;
                boy --;
                girl = boy + 1;
//            System.out.println("girl:" + girl);
                while(girl < n && c[girl] == 'G') girl ++;
                if(girl == n) break;
                girl --;
//            System.out.println("boy:" + boy);
                if(c[girl + 1] == 'B') {
                    count2 += (girl - boy);
                    char t = c[boy + 1];
                    c[boy + 1] = c[girl + 1];
                    c[girl + 1] = t;
                    boy ++;
                }
            }

        System.out.println(Math.min(count1, count2));
    }
}
