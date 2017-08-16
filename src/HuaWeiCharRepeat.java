import java.util.*;

public class HuaWeiCharRepeat{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int[] hash = new int[256];
            for(int i = 0; i<256; i++) hash[i] = 0;
            String s = scanner.nextLine();
            char[] cc = s.toCharArray();
            for(int i = 0; i<cc.length; i++) {
                hash[cc[i]]++;
                if (hash[cc[i]] == 1) System.out.print(cc[i]);
            }
        }
    }
}