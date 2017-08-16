import java.util.*;
public class BucketSort{
    public static void main(String[] args){
        int N=0;
        Set<Integer> set=new TreeSet<Integer>();
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            N=scanner.nextInt();
            set.clear();
            for(int i=0;i<N;i++){
                set.add(scanner.nextInt());
            }
            Iterator<Integer> it=set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}