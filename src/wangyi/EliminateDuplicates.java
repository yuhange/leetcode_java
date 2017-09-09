package wangyi;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 输入描述:
 输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50) 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格

 输入例子1:
 9 100 100 100 99 99 99 100 100 100
 */
import java.util.*;
public class EliminateDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for(int i = 0; i<n; i++) {
            p[i] = scanner.nextInt();
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = n - 1; i>=0; i--) {
            if(!list.contains(p[i])) list.add(p[i]);
//            set.add(scanner.nextInt());
        }
        String s = "";
        for(int i = list.size() - 1; i>=0; i--) s = s + list.get(i) + " ";
        s = s.substring(0, s.length() - 1);
        System.out.println(s);
    }
}
