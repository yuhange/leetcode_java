package adapter;

/**
 * Created by lenovo on 2017/3/19.
 */
public class MalardDuck implements Duck {
    @Override
    public void quak() {
        System.out.println("I'm a duck and I am quakking");
    }

    @Override
    public void fly() {
        System.out.println("I'm a duck and I am flying");
    }
}
