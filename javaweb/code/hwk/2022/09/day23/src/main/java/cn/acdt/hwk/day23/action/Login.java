package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.Config;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = {"/login", "/index.jsp"}, loadOnStartup = 1)
public class Login extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet Initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        System.out.println("doGet" + getClass().getSimpleName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        if (name.equals(Config.INSTANCE.getName()) && password.equals(Config.INSTANCE.getPassword())) {
            request.setAttribute("name", Config.INSTANCE.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "*用户名或密码错误*");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("doPost" + getClass().getSimpleName());
    }

    @Override
    public void destroy() {
    }
}