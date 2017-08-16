package strategy;

/**
 * Created by lenovo on 2017/3/13.
 */
public class ByTablet implements Writable {
    @Override
    public void write() {
        System.out.println("用平板写");
    }
}
