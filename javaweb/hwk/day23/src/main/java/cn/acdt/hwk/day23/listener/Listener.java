package cn.acdt.hwk.day23.listener;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 侦听器
 *
 * @author zzwtsy
 * @date 2022/11/12
 */
@WebListener
public class Listener implements ServletContextListener {
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowTime = simpleDateFormat.format(date.getTime());


    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("ServletContext Initialized:" + nowTime);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("ServletContext Destroyed" + nowTime);
    }
}
