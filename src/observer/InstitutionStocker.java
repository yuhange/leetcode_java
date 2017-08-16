package observer;

/**
 * Created by lenovo on 2017/3/13.
 */
public class InstitutionStocker implements Observer {

    public InstitutionStocker(Stock stock) {
        stock.addObserver(this);
    }

    @Override
    public void update(double price) {
        System.out.println("交易所收到通知,股价为：" + price);
    }
}
