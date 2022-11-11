package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.Config;
import cn.acdt.hwk.day23.tools.UpdateCounter;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author 孟繁兴
 */
@WebServlet("/LoginSvl")
public class LoginSvl extends HttpServlet {

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
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        if (name.equals(Config.INSTANCE.getName()) && password.equals(Config.INSTANCE.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            ServletContext servletContext = this.getServletContext();
            new UpdateCounter().updateCounter(servletContext);
            Cookie cookie = new Cookie("myLogin", name);
            //cookie默认保存10分钟（600秒）
            cookie.setMaxAge(600);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            request.setAttribute("message", "*用户名或密码错误*");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("doPost-" + getClass().getSimpleName());
    }
}