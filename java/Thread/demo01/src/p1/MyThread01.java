package p1;

/**
 * Thread01
 *
 * @author zzwtsy
 * @since 2022/11/27
 */
public class MyThread01 extends Thread {
    @Override
    public void run() {
        System.out.println("这是子线程01:" + currentThread().getName() + "线程");
    }
}
