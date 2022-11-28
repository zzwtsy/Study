package p1;

import static java.lang.Thread.currentThread;

/**
 * @author zzwtsy
 * @since 2022/11/27
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("这是主线程:" + currentThread().getName() + "线程");
        new MyThread01().start();
    }
}