package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.Config;
import cn.acdt.hwk.day23.tools.UpdateCounter;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @author 孟繁兴
 */
@Log4j2
@WebServlet("/LoginSvl")
public class LoginSvl extends HttpServlet {

    @Override
    public void init() {
        log.info("Servlet Initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        log.info("跳转登陆界面");
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
            new UpdateCounter().updateCounter(servletContext);
            Cookie cookie = new Cookie("myLogin", name);
            //cookie默认保存10分钟（600秒）
            cookie.setMaxAge(600);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            log.info("用户登陆成功");
        } else {
            request.setAttribute("message", "*用户名或密码错误*");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            log.info("用户登陆失败");
        }
    }
}