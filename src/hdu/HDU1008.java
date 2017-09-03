package hdu;

/**
 * Problem Description
 The highest building in our city has only one elevator. A request list is made up with N positive numbers. The numbers denote at which floors the elevator will stop, in specified order. It costs 6 seconds to move the elevator up one floor, and 4 seconds to move down one floor. The elevator will stay for 5 seconds at each stop.

 For a given request list, you are to compute the total time spent to fulfill the requests on the list. The elevator is on the 0th floor at the beginning and does not have to return to the ground floor when the requests are fulfilled.


 Input
 There are multiple test cases. Each case contains a positive integer N, followed by N positive numbers. All the numbers in the input are less than 100. A test case with N = 0 denotes the end of input. This test case is not to be processed.


 Output
 Print the total time on a single line for each test case.


 Sample Input
 1 2
 3 2 3 1
 0


 Sample Output
 17
 41

 */
import java.util.*;
public class HDU1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            int[] num = new int[n];
            for(int i = 0; i<n; i++) num[i] = scanner.nextInt();
            int sum = num[0] * 6 + 5;
            for(int i = 1; i<n; i++) {
                if(num[i] > num[i-1]) sum = sum + (num[i] - num[i-1]) * 6 + 5;
                else if(num[i] < num[i-1]) sum = sum + (num[i-1] - num[i]) * 4 + 5;
                else sum += 5;
            }
            System.out.println(sum);
        }
    }
}
