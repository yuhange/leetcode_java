package leetcode.medium.string;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int n = s.length();
        if(n <= 1) return s;
        String res = "";
        String[] ss = s.split("\\s+");
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
}
