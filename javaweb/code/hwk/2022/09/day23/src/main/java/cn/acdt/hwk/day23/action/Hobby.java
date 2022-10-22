package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = "/hobby")
public class Hobby extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<String> carts;
        if (session.getAttribute("carts") == null) {
            carts = new ArrayList<>();
        } else {
            carts = (ArrayList<String>) session.getAttribute("carts");
        }
        String[] goods = request.getParameterValues("goods");
        int num = 0;
        if (goods != null) {
            num = goods.length;
            Collections.addAll(carts, goods);
        }
        session.setAttribute("carts", carts);
        response.setContentType("text/html;charset=UTF-8");

//        request.setCharacterEncoding("UTF-8");
//        String[] hobby = request.getParameterValues("hobby");
//        if (hobby != null) {
//            System.out.println("***打印爱好开始***");
//            for (String hobbys : hobby) {
//                System.out.println(hobbys);
//            }
//            System.out.println("^^^打印爱好结束^^^");
    }
}
