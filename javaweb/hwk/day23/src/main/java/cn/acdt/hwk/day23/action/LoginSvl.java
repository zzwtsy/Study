package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.MySqlUtil;
import cn.acdt.hwk.day23.tools.UpdateCounter;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.sql.SQLException;
import java.util.Map;
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
        String identValue = "0";
        String sqlUsername;
        String sqlPassword;
        String sqlIdent;
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        String sql = "select * from user where username=? and password=?";
        Object[] params = new Object[]{name, password};
        try {
            Map<Object, Object> map = MySqlUtil.executeQuery(sql, params);
            sqlUsername = (String) map.get("username");
            sqlPassword = (String) map.get("password");
            sqlIdent = (String) map.get("ident");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (name.equals(sqlUsername) && password.equals(sqlPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            if (identValue.equals(sqlIdent)) {
                session.setAttribute("ident", "普通用户");
            } else {
                session.setAttribute("ident", "用户管理员");
            }
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