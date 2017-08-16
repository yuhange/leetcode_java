package adapter;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Test {
    public static void main(String[] args) {
        Turkey turkey = new Turkey();
        TurkeyDuck turkeyDuck = new TurkeyDuck(turkey);
        turkeyDuck.quak();
        turkeyDuck.fly();
    }
}
