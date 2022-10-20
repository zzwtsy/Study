package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.Config;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = {"/login", "/index.jsp"})
public class Login extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet Initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        System.out.println("doGet-" + getClass().getSimpleName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        if (name.equals(Config.INSTANCE.getName()) && password.equals(Config.INSTANCE.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            ServletContext servletContext = this.getServletContext();
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
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            request.setAttribute("message", "*用户名或密码错误*");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("doPost-" + getClass().getSimpleName());
    }

    @Override
    public void destroy() {
    }
}