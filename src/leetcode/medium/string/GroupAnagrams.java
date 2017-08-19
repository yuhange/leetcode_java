package leetcode.medium.string;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int n = strs.length;
        if(n == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s: strs) {
            String tmp = sort(s);
            if(!map.containsKey(tmp)) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(tmp, list);
            } else {
                map.get(tmp).add(s);
            }
        }
        for(String s: map.keySet()) {
            res.add(new ArrayList<String>(map.get(s)));
        }
        return res;
    }

    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
