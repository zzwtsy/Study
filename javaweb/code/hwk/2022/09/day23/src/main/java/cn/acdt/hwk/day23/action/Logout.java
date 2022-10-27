package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注销
 *
 * @author zzwtsy
 * @date 2022-10-27
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.println("正在退出，3秒后返回登陆页面");
            HttpSession session = request.getSession();
            session.invalidate();
            response.setHeader("Refresh", "3;URL=login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
