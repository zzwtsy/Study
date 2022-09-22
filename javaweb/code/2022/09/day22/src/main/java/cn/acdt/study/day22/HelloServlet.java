package cn.acdt.study.day22;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author zzwtsy
 */
@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet", "/Hello/*", "/Hello"})
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
    }

    @Override
    public void destroy() {
    }
}