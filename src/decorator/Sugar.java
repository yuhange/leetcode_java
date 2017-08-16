package decorator;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Sugar implements Coffee {
    private Coffee coffee;
    public Sugar(Coffee coffee) {
        super();
        this.coffee = coffee;
    }
    @Override
    public void show() {
        coffee.show();
        System.out.println("糖");
    }
}
