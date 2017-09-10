package leetcode.medium.string;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
import java.util.*;
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> first = new HashSet<String>();
        HashSet<String> second = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i<s.length()-9; i++) {
            String t = s.substring(i, i+10);
            if(first.contains(t)) second.add(t);
            else first.add(t);
        }
        for(String t: second) {
            res.add(t);
        }
        return res;
    }
}
