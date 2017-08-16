/**
 * Created by lenovo on 2017/3/7.
 */

class A implements Runnable {
    private int ticket = 10;
    public void run() {
        for(int i = 0; i<20; i++) {
            if(this.ticket>0) {
                System.out.println(Thread.currentThread().getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
}

public class MyThreadTest {

    public static void main(String[] args) {
        A a1 = new A();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a1);
        t1.start();
        t2.start();
        t3.start();
    }

}
