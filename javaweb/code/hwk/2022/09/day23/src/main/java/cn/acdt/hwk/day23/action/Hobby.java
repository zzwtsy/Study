package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = "/hobby")
public class Hobby extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String[] hobby = request.getParameterValues("hobby");
        if (hobby != null) {
            System.out.println("你的爱好：");
            for (String hobbys : hobby) {
                System.out.println(hobbys);
            }
        }
    }
}
