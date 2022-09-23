package cn.acdt.hwk.day23;

import cn.acdt.hwk.day23.tools.Config;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = {"/login", "/"})
public class Login extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet Initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        if (name.equals(Config.INSTANCE.getName()) && password.equals(Config.INSTANCE.getPassword())) {
            request.setAttribute("name", Config.INSTANCE.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "false");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}