/**
 * Created by lenovo on 2017/8/31.
 */
public class Test {

    public static void main(String[] agrs) {
        String greetings = "Hello";
        System.out.println("Hello".equals(greetings));
        System.out.println(greetings.compareTo("Hello") == 0);
        System.out.println(greetings == "Hello");
        System.out.println("Hello".equalsIgnoreCase(greetings));
    }
}
