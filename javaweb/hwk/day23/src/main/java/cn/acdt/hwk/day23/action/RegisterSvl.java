package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.database.DataBaseHelper;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zzwtsy
 */
@Log4j2
@WebServlet(urlPatterns = "/RegisterSvl")
public class RegisterSvl extends HttpServlet {
    private String registerStatic = "";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
        log.info("跳转注册界面");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("rusername");
        String password = request.getParameter("rpassword1");
        String sql = "INSERT INTO `user` SET username = ?, password = ?";
        Object[] params = new Object[]{name, password};
        try {
            if (DataBaseHelper.executeUpdate(sql, params) > 0) {
                registerStatic = "注册成功";
            } else {
                registerStatic = "注册失败";
            }
            session.setAttribute("registerStatic", registerStatic);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
        log.info("用户注册账户");
    }

    @Override
    public void destroy() {
        if (!"".equals(registerStatic)) {
            registerStatic = "";
        }
    }
}
