package cn.acdt.hwk.action.day27;

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
 * 自动登录
 * Servlet implementation class AutoLoginSvl
 *
 * @author zzwtsy
 * @date 2022/10/27
 */
@WebServlet("/AutoLoginSvl")
public class AutoLoginSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        //获取
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("uname");
        String password = request.getParameter("upwd");
        if ("admin".equals(username) && "admin".equals(password)) {
            //身份
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
            out.println("用户密码错误，3秒后返回登录页面………");
            response.setHeader("Refresh", "3;URT=/AutoLoginSvl");
        }
    }
}

	