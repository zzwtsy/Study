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
 * 注册svl
 *
 * @author zzwtsy
 * @since 2022/11/20
 */
@Log4j2
@WebServlet(urlPatterns = "/RegisterSvl")
public class RegisterSvl extends HttpServlet {
    /**
     * 注册状态
     */
    private String registerStatus = "";

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
        try {
            if (DataBaseHelper.executeUpdate(sql, name, password) > 0) {
                registerStatus = "注册成功";
            } else {
                registerStatus = "注册失败";
            }
            session.setAttribute("registerStatic", registerStatus);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
        log.info("用户注册账户");
    }

    @Override
    public void destroy() {
        if (!"".equals(registerStatus)) {
            registerStatus = "";
        }
    }
}
