package leetcode.medium.application;

import java.util.*;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrie {
    TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if(i == word.length() - 1) t.leaf = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.leaf == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!children.containsKey(c)) return null;
            t = children.get(c);
            children = t.children;
        }
        return t;
    }
}
class TrieNode {
    char val;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean leaf;
    public TrieNode(char val) {this.val = val;}
    public TrieNode(){}
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */