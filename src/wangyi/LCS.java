package wangyi;

/**
 * Created by lenovo on 2017/9/9.
 */
import java.util.*;
public class LCS {
    static String ss;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ss = scanner.next();
        int n = ss.length();
        generateParenthesis(n/2);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(String t: res) {
            int lcs = lcs(t, ss);
//            System.out.println(t + " " + ss + " " + lcs);
            if(lcs > max) {
                max = lcs;
            }
            if(map.containsKey(lcs)) {
//                System.out.println(map.get(max));
                map.put(lcs, map.get(lcs) + 1);
            }else {
                map.put(lcs, 1);
            }
        }
//        System.out.println(max);
        System.out.println(map.get(max));
    }

    private static int lcs(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 1; i<=s.length(); i++) {
            for(int j = 1; j<=t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    static List<String> res = new ArrayList<String>();

    public static List<String> generateParenthesis(int n) {
        if(n < 0) return res;
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String s) {
        if(right < left) return;
        if(left == 0 && right == 0) {
            if(!s.equals(ss))
                res.add(s);
        }
        if(left > 0) dfs(left - 1, right, s + "(");
        if(right > 0) dfs(left, right - 1, s + ")");
    }
}
