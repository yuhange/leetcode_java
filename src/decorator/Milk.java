package decorator;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Milk implements Coffee {
    private Coffee coffee;
    public Milk(Coffee coffee) {
        super();
        this.coffee = coffee;
    }
    @Override
    public void show() {
        coffee.show();
        System.out.println("奶");

    }
}
