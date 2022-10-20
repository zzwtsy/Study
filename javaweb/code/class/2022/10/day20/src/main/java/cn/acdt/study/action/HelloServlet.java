package cn.acdt.study.action;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * hello servlet
 *
 * @author zzwtsy
 * @date 2022-10-20
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
        String id = request.getSession().getId();
        HttpSession session = request.getSession();
        session.setAttribute("welcome", "欢迎");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(getClass() + ",Session:" + id);
        out.println("</body></html>");
        response.sendRedirect(request.getContextPath() + "/hello");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void destroy() {
    }
}