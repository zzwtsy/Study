package cn.acdt.hwk.day23;

import cn.acdt.hwk.day23.tools.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登记
 *
 * @author zzwtsy
 * @date 2022/09/23
 */
@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("rusername");
        String password = request.getParameter("rpassword1");
        Config.INSTANCE.setName(name);
        Config.INSTANCE.setPassword(password);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
