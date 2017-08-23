package leetcode.medium.string;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] map1 = new int[128];
        int n = s1.length();
        for(int i = 0; i<n; i++) map1[s1.charAt(i)] ++;
        for(int i = 0; i<=s2.length() - n; i++) {
            String tmp = s2.substring(i, i + n);
            // System.out.println(tmp);
            int[] map2 = new int[128];
            for(int j = 0; j<n; j++) map2[tmp.charAt(j)] ++;
            boolean exists = true;
            for(int j = 0; j<128; j++) {
                if(map1[j] != map2[j]) {
                    exists = false;
                    break;
                }
            }
            if(exists) return true;
        }
        return false;
    }
}
