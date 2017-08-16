package decorator;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Original implements Coffee {
    @Override
    public void show() {
        System.out.println("原味咖啡，内加：");
    }
}
