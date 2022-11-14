import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * @author 孟繁兴
 */
public class DateTest {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date.getTime());
        System.out.println(simpleDateFormat.format(date.getTime()));
        sleep(3000);
        System.out.println(simpleDateFormat.format(date.getTime()));
        sleep(3000);
        System.out.println(simpleDateFormat.format(date.getTime()));
        sleep(3000);
        System.out.println(simpleDateFormat.format(date.getTime()));
    }
}
