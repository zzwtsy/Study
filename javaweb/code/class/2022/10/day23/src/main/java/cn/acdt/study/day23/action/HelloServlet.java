package cn.acdt.study.day23.action;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author zzwtsy
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        System.out.println("pathInfo:" + pathInfo);
        System.out.println("servletPath:" + servletPath);
        System.out.println("contextPath:" + contextPath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void destroy() {
    }
}