package leetcode.medium.application;

import java.util.*;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word
     could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        // if(root.search(word)) return true;
        return search(word, root);
    }

    private boolean search(String word, TrieNode root) {
        if(word.length() == 0) return root.leaf;
        if(root == null) return false;
        HashMap<Character, TrieNode> children = root.children;
        char c = word.charAt(0);
        if(c == '.') {
            for(char key: children.keySet()) {
                if(search(word.substring(1), children.get(key))) return true;
            }
            return false;
        } else if(!children.containsKey(c)) return false;
        else {
            return search(word.substring(1), children.get(c));
        }
    }
}

//class TrieNode {
//    char val;
//    boolean leaf;
//    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//
//    public TrieNode(char val) {this.val = val;}
//    public TrieNode() {}
//}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */