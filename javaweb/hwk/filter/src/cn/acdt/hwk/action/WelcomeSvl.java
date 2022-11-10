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
 * @author zzwtsy
 * @date 2022-11-10
 */
@WebServlet("/WelcomeSvl")
public class WelcomeSvl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("mayLogin".equals(cookie.getName())) {
                    session.setAttribute("username", cookie.getValue());
                    break;
                }
            }
        }
        String user = (String) session.getAttribute("username");

        if (user == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("您还没有登陆，3秒后返回登陆界面。。。");
            response.setHeader("Refresh", "3;URL=AutoLoginSvl");
        } else {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
