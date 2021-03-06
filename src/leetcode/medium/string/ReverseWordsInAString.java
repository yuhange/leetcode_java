package leetcode.medium.string;

/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int n = s.length();
        if(n <= 1) return s;
        char[] c = s.toCharArray();
        reverse(c, 0, n - 1);
        String res = "";
        String[] ss = new String(c).split("\\s+");
        for(int i = 0; i<ss.length; i++) {
            char[] cc = ss[i].toCharArray();
            reverse(cc, 0, cc.length - 1);
            res += new String(cc);
            if(i != ss.length - 1) res += " ";
        }
        return res;
    }

    private void reverse(char[] c, int i, int j) {
        while(i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i ++;
            j --;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        System.out.print(r.reverseWords("the sky is blue"));
    }
}
