package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Account {
    private int money;
    public Account(int money) {
        this.money = money;
    }
    public int getMoney() {
        return this.money;
    }
    public void withDraw(int withDraw) {
        this.money -= withDraw;
    }
    public void dropIn(int dropIn) {
        this.money += dropIn;
    }
}
