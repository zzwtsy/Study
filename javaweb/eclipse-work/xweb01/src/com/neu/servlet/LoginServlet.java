package com.neu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.User;
import com.neu.dao.UserDao;

/**
 * 登录Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 登录验证
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 代码编写处
        User user;
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName == null || userName.trim().equals("") || password == null || password.trim().equals("")) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            user = new UserDao().getUserByName(userName);
            String name = user.getUserName();
            String pwdString = user.getPassword();
            if (userName.equals(name) && password.equals(pwdString)) {
                session.setAttribute("user", userName);
                response.sendRedirect(request.getContextPath() + "/users");
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}
