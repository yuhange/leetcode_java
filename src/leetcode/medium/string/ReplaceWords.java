package leetcode.medium.string;

import java.util.*;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

 Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

 You need to output the sentence after the replacement.

 Example 1:
 Input: dict = ["cat", "bat", "rat"]
 sentence = "the cattle was rattled by the battery"
 Output: "the cat was rat by the bat"
 Note:
 The input will only have lower-case letters.
 1 <= dict words number <= 1000
 1 <= sentence words number <= 1000
 1 <= root length <= 100
 1 <= sentence words length <= 1000
 */
public class ReplaceWords {
    // 可以用Trie做
    public String replaceWords(List<String> dict, String sentence) {
        HashMap<String, String> map = new HashMap<String, String>();
        String[] ss = sentence.split(" ");
        for(String s: ss) {
            int min = Integer.MAX_VALUE;
            String realRoot = "";
            for(String root: dict) {
                if(s.startsWith(root)) {
                    if(min > root.length()) {
                        min = root.length();
                        realRoot = root;
                    }
                }
            }
            if(realRoot.length() > 0) map.put(s, realRoot);
            else map.put(s, s);
        }
        String res = "";
        for(int i = 0; i<ss.length; i++) {
            if(i != ss.length - 1) {
                res = res + map.get(ss[i]) + " ";
            } else res = res + map.get(ss[i]);
        }
        return res;
    }
}
