package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zzwtsy
 */
@WebServlet(urlPatterns = "/hobby")
public class Hobby extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<String> sessionCarts = (ArrayList<String>) request.getSession().getAttribute("carts");
        ArrayList<String> carts;
        if (sessionCarts == null) {
            carts = new ArrayList<>();
        } else {
            carts = sessionCarts;
        }
        String[] goods = request.getParameterValues("goods");
        int num = 0;
        if (goods != null) {
            num = goods.length;
            Collections.addAll(carts, goods);
        }
        request.getSession().setAttribute("carts", carts);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html>\n" +
                    "\n" +
                    "<head>\n" +
                    "    <link rel=\"stylesheet\" href=\"./css/style.css\">\n" +
                    "    <style>\n" +
                    "        .button {\n" +
                    "            width: 90%;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<div class=\"login\">\n" +
                    "    <div class=\"circle-orange\"></div>\n" +
                    "    <form class=\"z-index99\">\n" +
                    "        <h3>您添加了" + num + "件商品</h3><br>\n" +
                    "        <div class=\"z-index99 button-box\">\n" +
                    "            <a href=\"welcome.jsp\">\n" +
                    "                <button class=\"button\" type=\"button\">继续购物</button>\n" +
                    "            </a>\n" +
                    "            <a href=\"ShowShoppingCart\">\n" +
                    "                <button class=\"button\" type=\"button\">查看购物车</button>\n" +
                    "            </a>\n" +
                    "            <a href=\"login.jsp\">\n" +
                    "                <button class=\"button\" type=\"button\">退出</button>\n" +
                    "            </a>\n" +
                    "        </div>\n" +
                    "        <div class=\"circle-blue\"></div>\n" +
                    "</div>\n" +
                    "\n" +
                    "</html>");
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

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
