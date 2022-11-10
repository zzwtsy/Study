package cn.acdt.hwk.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author meng
 */
@WebServlet("/AutoLoginSvl")
public class AutoLoginSvl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("孟繁兴".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            String choice = request.getParameter("choice");
            if (choice != null) {
                Cookie cookie = new Cookie("myLogin", username);
                cookie.setMaxAge(Integer.parseInt(choice));
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("密码错误，3秒后返回登陆界面。。。");
            response.setHeader("Refresh", "3;URL=AutoLoginSvl");
        }
    }
}

	