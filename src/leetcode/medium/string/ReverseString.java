package leetcode.medium.string;

/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        int n = s.length();
        if(n <= 1) return s;
        char[] c = s.toCharArray();
        reverse(c, 0, n - 1);
        return new String(c);
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
