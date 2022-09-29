package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = "/hobby")
public class Hobby extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String[] hobby = request.getParameterValues("hobby");
        if (hobby != null) {
            System.out.println("***打印爱好开始***");
            for (String hobbys : hobby) {
                System.out.println(hobbys);
            }
            System.out.println("^^^打印爱好结束^^^");
        }
    }
}
