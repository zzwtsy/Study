package cn.acdt.jdbc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.acdt.jdbc.tools.MysqlUtil;

/**
 * 
 * @author 孟繁兴
 * @date 2022/11/17
 */
@WebServlet("/LoginSvl")
public class LoginSvl extends HttpServlet {

    private static final long serialVersionUID = -5737138224905040199L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("/html/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ResultSet rs = null;
        PrintWriter outPrintWriter = response.getWriter();
        String username = request.getParameter("username").trim();
        String userPassword = request.getParameter("userpassword").trim();
        if (username == null || userPassword == null || username.equals("") || userPassword.equals("")) {
            // 未输入用户名或密码，或输入为空字符串
            response.setContentType("text/html;charset=UTF-8");
            outPrintWriter.print("请输入用户名和密码， 再<a href=\"LoginSvl\">登录</a>");
        } else {
            try {
                // 声名语句
                String sql = "select * from user where username='" + username + "' and password='" + userPassword + "'";
                // 执行语句
                rs = new MysqlUtil().executeQuery(sql);
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    String ident = rs.getString("ident");
                    session.setAttribute("username", rs.getString("username"));
                    if ("0".equals(ident)) {
                        session.setAttribute("ident", "普通用户");
                    } else {
                        session.setAttribute("ident", "用户管理员");
                    }
                    request.getRequestDispatcher("/html/welcome.jsp").forward(request, response);
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    outPrintWriter.println("用户名或密码错误， 请<a href=\"LoginSvl\">登录</a>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
