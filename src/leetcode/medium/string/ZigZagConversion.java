package leetcode.medium.string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n <= 1) return s;
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i<numRows; i++) sb[i] = new StringBuffer();

        int i = 0;
        while(i < n) {
            for(int idx = 0; idx<numRows && i < n; idx++) sb[idx].append(s.charAt(i++));
            for(int idx = numRows - 2; idx >=1 && i < n; idx --) sb[idx].append(s.charAt(i++));
        }
        for(i = 1; i<numRows; i++) sb[0].append(sb[i]);
        return sb[0].toString();
    }
}
