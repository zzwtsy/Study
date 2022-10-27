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
 * 欢迎
 * Servlet implementation class WelcomeSvl
 *
 * @author zzwtsy
 * @date 2022/10/27
 */
@WebServlet("/WelcomeSvl")
public class WelcomeSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("myLogin".equals(cookie.getName())) {
                    session.setAttribute("username", cookie.getValue());
                    break;
                }
            }
        }
        String user = (String) session.getAttribute("username");
        if (user == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("您还没有登录，请先登录，3秒后返回登录页面……");
            response.setHeader("Refresh", "3;URL=AutoLoginSvl");
        } else {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    }
}
