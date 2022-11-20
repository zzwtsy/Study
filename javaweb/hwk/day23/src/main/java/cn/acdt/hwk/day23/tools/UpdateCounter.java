package cn.acdt.hwk.day23.tools;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * 更新计数器
 *
 * @author 孟繁兴
 * @since 2022/10/29
 */
@Log4j2
public class UpdateCounter extends HttpServlet {
    /**
     * 更新计数器
     *
     * @param servletContext servletContext
     */
    public void updateCounter(ServletContext servletContext) {
        //计数器
        int count;
        if (servletContext.getAttribute("count") == null) {
            log.info("用户登录第一次登陆创建count属性");
            //表示第一次用户登录进来，这时还没有创建count属性，创建此属性，并将其置为1
            servletContext.setAttribute("count", 1);
        } else {
            log.info("更新count属性");
            count = (Integer) servletContext.getAttribute("count");
            count++;
            //重新更新count属性中的数据
            servletContext.setAttribute("count", count);
        }
    }
}
