package leetcode.medium.recursive;

import java.util.*;

/**
 * Created by lenovo on 2017/8/15.
 */
public class LetterCombinationsofPhoneNumber {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        char[][] cc = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        int[] d = new int[10];
        int[] c = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        char[] di = digits.toCharArray();
        for(int i = 0; i<di.length; i++) {
            dfs(i, "", d, c, cc);
        }

        return res;
    }

    private void dfs(int index, String s, int[] d, int[] c, char[][] cc) {
        if(d[index] == c[index]) res.add(s);
        if(d[index] != c[index]) {
            d[index] ++;
            dfs(index, s+cc[index][d[index]-1], d, c, cc);
        }
    }
}
