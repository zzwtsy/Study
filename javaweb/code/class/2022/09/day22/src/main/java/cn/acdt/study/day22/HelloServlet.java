package cn.acdt.study.day22;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author 孟繁兴
 */
@WebServlet(name = "helloServlet", urlPatterns = {"/Hello/*"},
        //所有对象在启动时创建
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "name", value = "daydreamer"),
                @WebInitParam(name = "password", value = "123")
        })
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
        System.out.println("Servlet initialization");
        System.out.println("用户名: " + getInitParameter("name"));
        System.out.println("密码: " + getInitParameter("password"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Servlet response Service ");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        System.out.println("Servlet response doGet");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destruction");
    }
}