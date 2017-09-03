package hdu;

/**
 * Problem Description
 Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest is over, they will count the balloons of each color and find the result.

 This year, they decide to leave this lovely job to you.


 Input
 Input contains multiple test cases. Each test case starts with a number N (0 < N <= 1000) -- the total number of balloons distributed. The next N lines contain one color each. The color of a balloon is a string of up to 15 lower-case letters.

 A test case with N = 0 terminates the input and this test case is not to be processed.


 Output
 For each case, print the color of balloon for the most popular problem on a single line. It is guaranteed that there is a unique solution for each test case.


 Sample Input
 5
 green
 red
 blue
 red
 red
 3
 pink
 orange
 pink
 0


 Sample Output
 red
 pink
 */
import java.util.*;
public class HDU1004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for(int i = 0; i<n; i++) {
                String color = scanner.next();
                if(map.containsKey(color)) {
                    map.put(color, map.get(color) + 1);
                } else {
                    map.put(color, 1);
                }
            }
            int max = 0;
            String maxColor = null;
            for(Map.Entry<String, Integer> e: map.entrySet()) {
                if(e.getValue() > max) {
                    max = e.getValue();
                    maxColor = e.getKey();
                }
            }
            System.out.println(maxColor);
        }
    }
}
