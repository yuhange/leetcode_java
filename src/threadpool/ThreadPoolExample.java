package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/21.
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 2000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)) ;
        for(int i = 0; i<20; i++) {
            MyThread mt = new MyThread(i);
            threadPoolExecutor.execute(mt);
            System.out.println("线程池中的线程数："+threadPoolExecutor.getPoolSize()+"队列中等待的线程数："
                    +threadPoolExecutor.getQueue().size()+",已经执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}

class MyThread implements Runnable {

    private int num;

    public MyThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在运行Task"+this.num);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task"+this.num+"执行完毕");
    }
}
