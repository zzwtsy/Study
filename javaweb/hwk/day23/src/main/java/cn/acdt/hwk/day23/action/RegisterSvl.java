package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.Config;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zzwtsy
 */
@Log4j2
@WebServlet(urlPatterns = "/RegisterSvl")
public class RegisterSvl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
        log.info("跳转注册界面");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("rusername");
        String password = request.getParameter("rpassword1");
        Config.INSTANCE.setName(name);
        Config.INSTANCE.setPassword(password);
        request.getRequestDispatcher("login.jsp").forward(request, response);
        log.info("用户注册账户");
    }
}
