package cn.acdt.hwk.day23.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间
 *
 * @author 孟繁兴
 * @since  2022/11/13
 */
public class GetNowTime {
    /**
     * 获取当前时间
     *
     * @return {@code String}
     */
    public static String getNowTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date.getTime());
    }
}
