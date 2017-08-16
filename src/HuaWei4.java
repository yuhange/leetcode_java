import java.util.*;

public class HuaWei4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList<String>();
        int count = 2;
        while(count>0 && scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = s.length();
            if(len<8) {
                for(int i = 0; i<8-len; i++) s += "0";
                list.add(s);
            }else if(len == 8) list.add(s);
            else {
                int times = len/8;
                int extra = len%8;
                int index = 0;
                while(times>0) {
                    String tmp = s.substring(index, index + 8);
                    index+=8;
                    times--;
                    list.add(tmp);
                }
                String tmp = s.substring(index, index + extra);
                for(int i = 0; i<8-extra; i++) tmp += "0";
                list.add(tmp);
            }
            count -- ;
        }
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}