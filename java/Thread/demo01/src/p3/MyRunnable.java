package p3;

import static java.lang.Thread.currentThread;

/**
 * 当线程已经有父类就不能继承Thread类
 *
 * @author zzwtsy
 * @since 2022/11/27
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
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
