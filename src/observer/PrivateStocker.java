package observer;

/**
 * Created by lenovo on 2017/3/13.
 */
public class PrivateStocker implements Observer {


    public PrivateStocker(Stock stock) {
        stock.addObserver(this);
    }

    @Override
    public void update(double price) {
        System.out.println("个人持有者收到通知,股价为："+price);
    }
}
