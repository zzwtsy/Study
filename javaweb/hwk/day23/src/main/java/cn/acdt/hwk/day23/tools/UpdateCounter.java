package cn.acdt.hwk.day23.tools;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * 更新计数器
 *
 * @author 孟繁兴
 * @date 2022/10/29
 */
public class UpdateCounter extends HttpServlet {
    public void updateCounter(ServletContext servletContext) {
        //计数器
        int count;
        if (servletContext.getAttribute("count") == null) {
            //表示第一次用户登录进来，这时还没有创建count属性，创建此属性，并将其置为1
            servletContext.setAttribute("count", 1);
        } else {
            count = (Integer) servletContext.getAttribute("count");
            count++;
            //重新更新count属性中的数据
            servletContext.setAttribute("count", count);
        }
    }
}
