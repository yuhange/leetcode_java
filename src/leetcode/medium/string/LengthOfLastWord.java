package leetcode.medium.string;

/**
 * Created by lenovo on 2017/8/23.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split("\\s+");
        if(ss.length == 0) return 0;
        return ss[ss.length - 1].length();
    }
}
