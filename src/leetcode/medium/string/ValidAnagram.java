package leetcode.medium.string;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for(int i = 0; i<s.length(); i++) mapS[s.charAt(i)] ++;
        for(int i = 0; i<t.length(); i++) mapT[t.charAt(i)] ++;
        for(int i = 0; i<256; i++) {
            if(mapS[i] != mapT[i]) {
                return false;
            }
        }
        return true;
    }
}
