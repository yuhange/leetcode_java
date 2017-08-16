import java.util.*;

public class Caculator {
    public int postfixCal(String s) {
        Stack<Integer> sOperator = new Stack<Integer>();
        Stack<Integer> sOperation = new Stack<Integer>();
        int n = s.length();
        int result = 0;
        int i = 0;
        while(i<n) {
            if(!isOperator(s.charAt(i))) {
                char c = s.charAt(i);
                if(c<='F' && c>='A') sOperation.push(c-'A'+10);
                else if(c<='f' && c>='a') sOperation.push(c-'a'+10);
                else sOperation.push(c-'0');
            }else {
                char c = s.charAt(i);
                int second = sOperation.pop();
                int first = sOperation.pop();
                switch(c){
                    case '+':
                        result = (first + second);
                        break;
                    case '-':
                        result = (first - second);
                        break;
                    case '*':
                        result = first * second;
                        break;
                }
                sOperation.push(result);
            }
            i++;
        }
        return sOperation.pop();
    }
    public boolean isOperator(char c) {
        return (c=='+' || c=='-' || c=='*');
    }
    public boolean isHigher(char first, char second) {
        if((first == '+' && second=='*') || (first == '-' && second=='*')) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Caculator c = new Caculator();
        System.out.println(c.postfixCal(scanner.nextLine()));
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            if( (c<='Z' && c>='A' || c<='z' && c>='a')) sb.append(c+"");
//        }
//        System.out.println(sb.toString().toLowerCase());
    }
}