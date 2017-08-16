import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by lenovo on 2017/3/17.
 */
public class StringReverse {
    public String reverse(String s) {
        s = reverseBetween(s);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = s.length();
        while(i<n && j<n) {
            while(i<n && s.charAt(i) == ' ') {
                i++;
                sb.append(" ");
            }
            j = i;
            while(j<n && s.charAt(j) != ' ') j++;
            sb.append(reverseBetween(s.substring(i, j)));
            i = j;
        }
        return reverseBetween(sb.toString());
    }

    public String reverseBetween(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char[] cc = s.toCharArray();
        int i = 0;
        int j = n-1;
        while(i<j){
            char tmp = cc[i];
            cc[i] = cc[j];
            cc[j] = tmp;
            i++;
            j--;
        }
        for(i = 0; i<n; i++) sb.append(cc[i] + "");
        return sb.toString();
    }

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();
        System.out.print(sr.reverse("    a  45 3   ney3y4y5"));
    }
}
