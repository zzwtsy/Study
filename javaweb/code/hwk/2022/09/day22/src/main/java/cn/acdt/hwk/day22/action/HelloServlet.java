package cn.acdt.hwk.day22.action;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "helloServlet", urlPatterns = {"/hello-servlet", "/Hello/*"},
        asyncSupported = true,
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "name", value = "Daydreamer"),
                @WebInitParam(name = "pwd", value = "123")
        }
)
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("Servlet 初始化 init");
        System.out.println("name: " + getInitParameter("name")
                + "\npwd: " + getInitParameter("pwd")
        );
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Servlet 处理请求 server");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        System.out.println("Servlet 处理请求 doGet");
    }

    public void destroy() {
        System.out.println("Servlet 销毁");
    }
}