import java.util.*;
public class SAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        int c[] = new int[n];
        for(int i = 0; i<n; i++) {
            c[i] = (a.charAt(i) ^ b.charAt(i));
        }
        int result = 0;
        int base = 1;
        for(int i = n-1; i>=0; i--) {
            result += base*c[i];
            base *= 2;
        }
        System.out.println(result);
    }

}