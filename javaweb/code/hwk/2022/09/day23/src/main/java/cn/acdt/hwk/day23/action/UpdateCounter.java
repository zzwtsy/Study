package cn.acdt.hwk.day23.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 购物
 *
 * @author zzwtsy
 * @date 2022-10-27
 */
@WebServlet("/UpdateCounter")
public class UpdateCounter extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int count;
            ServletContext servletContext = this.getServletContext();
            count = (Integer) servletContext.getAttribute("count");
            count++;
            //重新更新count属性中的数据
            servletContext.setAttribute("count", count);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
