package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.database.DataBaseHelper;
import cn.acdt.hwk.day23.tools.UpdateCounter;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
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
        List<Map<Object, Object>> list;
        String identValue = "0";
        String sqlIdent;
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        String sql = "select * from user where username=? and password=?";
        try {
            list = DataBaseHelper.executeQuery(sql, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (list.size() > 0) {
            Map<Object, Object> map = list.get(0);
            sqlIdent = (String) map.get("ident");
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