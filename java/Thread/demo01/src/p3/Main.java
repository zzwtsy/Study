package p3;

import static java.lang.Thread.currentThread;

/**
 * 主要
 *
 * @author zzwtsy
 * @since 2022/11/27
 */
public class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + currentThread().getName() + "线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}