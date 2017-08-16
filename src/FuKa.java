import java.util.*;

public class FuKa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sum = new int[5];
        for(int i = 0; i<5; i++) sum[i] = 0;
        while(scanner.hasNext()) {
            String s = scanner.next();
            for(int i = 0; i<5; i++) {
                int cur = s.charAt(i)-'0';
                sum[i] += cur;
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[0]);
    }
}