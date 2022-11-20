package cn.acdt.hwk.day23.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import static cn.acdt.hwk.day23.tools.GetNowTime.getNowTime;

/**
 * 侦听器
 *
 * @author zzwtsy
 * @since 2022/11/12
 */
@Log4j2
@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContext Initialized[" + getNowTime() + "]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContext Destroyed[" + getNowTime() + "]");
    }
}
