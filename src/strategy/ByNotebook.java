package strategy;

/**
 * Created by lenovo on 2017/3/13.
 */
public class ByNotebook implements Writable {
    @Override
    public void write() {
        System.out.println("用记事本写");
    }
}
