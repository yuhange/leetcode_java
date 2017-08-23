package leetcode.medium.string;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] c) {
        reverse(c, 0, c.length - 1);
        int i = 0;
        int j = 0;
        while(i < c.length && j < c.length) {
            j = i + 1;
            while(j < c.length && c[j] != '0') j ++;
            reverse(c, i, j - 1);
            i = j + 1;
            j ++;
        }
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
        char[] c = new String("the sky is blue").toCharArray();
        ReverseWordsInAStringII reverseWordsInAStringII = new ReverseWordsInAStringII();
        reverseWordsInAStringII.reverseWords(c);
        for(char x: c) System.out.print(x);
    }
}
