package hdu;

/**
 * Problem Description
 Given a sequence a[1],a[2],a[3]......a[n], your job is to calculate the max sum of a sub-sequence. For example, given (6,-1,5,4,-7), the max sum in this sequence is 6 + (-1) + 5 + 4 = 14.


 Input
 The first line of the input contains an integer T(1<=T<=20) which means the number of test cases. Then T lines follow, each line starts with a number N(1<=N<=100000), then N integers followed(all the integers are between -1000 and 1000).


 Output
 For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case. The second line contains three integers, the Max Sum in the sequence, the start position of the sub-sequence, the end position of the sub-sequence. If there are more than one result, output the first one. Output a blank line between two cases.


 Sample Input
 2
 5 6 -1 5 4 -7
 7 0 6 -1 1 -6 7 -5


 Sample Output
 Case 1:
 14 1 4

 Case 2:
 7 1 6

 */
import java.util.*;
public class HDU1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 测试用例个数
        int count = 0;
        while(count < n) {
            count ++;
            int m = scanner.nextInt(); // 数组长度
            int[] num = new int[m];
            for(int i = 0; i<m; i++) num[i] = scanner.nextInt();

            long max = Integer.MIN_VALUE;
            long sum = 0;
            int start = 0;
            int end = -1;
            int startMax = 0;
            int endMax = 0;
            for(int i = 0; i<m; i++) {
                if(sum < 0) {
                    sum = num[i];
                    start = i;
                    end = i;
                }
                else {
                    sum += num[i];
                    end ++;
                }
                if(sum > max) {
                    max = sum;
                    startMax = start;
                    endMax = end;
                }
//                System.out.println(sum);
            }
            System.out.println("Case " + count + ":");
            System.out.println(max + " " + (startMax + 1) + " " + (endMax + 1));
            if(count != n) System.out.println();
        }
    }
}
