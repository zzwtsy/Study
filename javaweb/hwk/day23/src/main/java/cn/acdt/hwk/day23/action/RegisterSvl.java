package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.database.*;
import lombok.extern.log4j.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

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
        List<Map<Object, Object>> checkUserNameList;
        HttpSession session = request.getSession();
        String name = request.getParameter("rusername");
        String password = request.getParameter("rpassword1");
        String checkUserNameSql = "SELECT username FROM `user` WHERE username = ?";
        try {
            checkUserNameList = DataBaseHelper.executeQuery(checkUserNameSql, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //判断用户名是否已注册
        if (checkUserNameList.size() > 0) {
            registerStatus = "用户名已注册";
        } else {
            String sql = "INSERT INTO `user` SET username = ?, password = ?";
            try {
                if (DataBaseHelper.executeUpdate(sql, name, password) > 0) {
                    registerStatus = "注册成功";
                } else {
                    registerStatus = "注册失败";
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        session.setAttribute("registerStatic", registerStatus);
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
