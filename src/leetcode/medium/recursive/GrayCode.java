package leetcode.medium.recursive;

import java.util.*;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayCode {
    int[] a;
    boolean[] v;
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> grayCode(int n) {
        if(n == 0) return res;
        for(int i = 0; i<1<<n; i++) {
            res.add(i ^ i>>1);
        }
        // a = new int[n];
        // v = new boolean[max(n) + 1];
        // dfs(a, 0, n, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] a, int pos, int n, List<Integer> list) {
        if(pos == n) {
            res = new ArrayList<Integer>(list);
            return;
        }
        for(int i = pos; i<n; i++) {
            int ori = a[i];
            if(ori == 0) a[i] = 1;
            else if(ori == 1) a[i] = 0;
            int cur = trans(a);
            if(v[cur] == true) continue;
            list.add(cur);
            v[cur] = true;
            dfs(a, i + 1, n, list);
            v[cur] = false;
            list.remove(list.size()-1);
            a[i] = ori;
        }
    }

    private int trans(int[] a) {
        int res = 0;
        int base = 1;
        for(int i = a.length - 1; i >= 0; i--) {
            res += a[i]*base;
            base *= 2;
        }
        return res;
    }

    private int max(int n) {
        int res = 1;
        for(int i = 0; i<n; i++) {
            res *= 2;
        }
        return res - 1;
    }
}
