package facade;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade(new Fan(), new TV(), new Light());
        facade.startShow();
        facade.endShow();
    }
}
