package strategy;

/**
 * Created by lenovo on 2017/3/13.
 */
public class People {
    Writable writable;
    public People(Writable writable) {
        this.writable = writable;
    }

    public void record() {
        writable.write();
    }
}
