package observer;

/**
 * Created by lenovo on 2017/3/13.
 */
public class Test {
    public static void main(String[] args) {
        Stock stock = new Stock(0.8d);
        PrivateStocker privateStocker = new PrivateStocker(stock);
        InstitutionStocker institutionStocker = new InstitutionStocker(stock);
        stock.setPrice(10.4d);
    }
}
