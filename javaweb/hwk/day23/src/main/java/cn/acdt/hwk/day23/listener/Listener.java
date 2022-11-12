package cn.acdt.hwk.day23.listener;

import lombok.extern.log4j.Log4j2;

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
@Log4j2
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
        log.info("ServletContext Initialized[" + nowTime + "]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        log.info("ServletContext Destroyed[" + nowTime + "]");
    }
}
