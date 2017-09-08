package jingdong;

import java.util.*;
/**
 * Created by lenovo on 2017/9/8.
 */
public class Parenthese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.length() == 0) {
            System.out.println(0);
            return;
        }
        long res = 1;
        int i = 0;
        while(i < s.length() ) {
            int j = i;
            while(j < s.length() && s.charAt(j) == '(') j++; // 获得连续的(的长度
            int a = j - i;
//            System.out.println(j);
            i = j;
            while(j < s.length() && s.charAt(j) == ')') j++; // 获得连续的)的长度
            int b = j - i;
            System.out.println(a + " " + b);
            res *= getA(Math.min(a, b));
            System.out.println(res);
            i = j;
        }
        System.out.println(res);
    }

    private static long getA(int n) {
        long res = 1;
        while(n > 0) {
            res *= n;
            n --;
        }
        return res;
    }
}