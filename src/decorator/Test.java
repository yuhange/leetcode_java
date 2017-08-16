package decorator;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Test {
    public static void main(String[] args){
        Coffee coffee = new Sugar(new Milk(new Original()));
        coffee.show();
    }
}
