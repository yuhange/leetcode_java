package leetcode.medium.string;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int n = s.length();
        if(n <= 1) return s;
        int i = 0;
        int j = n - 1;
        char[] c = s.toCharArray();
        while(i < j) {
            while(i < j && !isVowel(c[i])) i ++;
            while(i < j && !isVowel(c[j])) j --;
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i ++;
            j --;
        }
        return new String(c);
    }

    private boolean isVowel(char c) {
        return (c == 'a') || (c == 'A') || (c == 'e') || (c == 'E') || (c == 'o') || (c == 'O') || (c == 'u') || (c == 'U') || (c == 'i') || (c == 'I');
    }
}
