package adapter;

/**
 * Created by lenovo on 2017/3/19.
 */
public class TurkeyDuck implements Duck {
    Turkey turkey;
    public TurkeyDuck(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quak() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
