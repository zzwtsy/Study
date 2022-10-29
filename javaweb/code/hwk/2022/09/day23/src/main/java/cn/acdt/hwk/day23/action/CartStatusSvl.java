package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = "/CartStatusSvl")
public class CartStatusSvl extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //检测用户是否登陆
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("myLogin".equals(cookie.getName())) {
                    session.setAttribute("name", cookie.getValue());
                    break;
                }
            }
        }
        String user = (String) session.getAttribute("name");
        if (user == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("您还没有登录，请先登录，3秒后返回登录页面……");
            response.setHeader("Refresh", "3;URL=LoginSvl");
        } else {
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
                        "    <link rel=\"stylesheet\" href=\"./css/ShowCartSvl.css\">\n" +
                        "    <link rel=\"stylesheet\" href=\"./css/welcome.css\">\n" +
                        "    <style>\n" +
                        "        .button {\n" +
                        "            width: 90%;\n" +
                        "        }\n" +
                        "        .add-shop-cart-btn {\n" +
                        "            margin: 20px auto 0 auto;\n" +
                        "        }" +
                        "        a {\n" +
                        "            color: #fff;\n" +
                        "        }\n" +
                        "        a:hover {\n" +
                        "           color: #0066cc;\n" +
                        "        }" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<div class=\"login\">\n" +
                        "    <form class=\"z-index99\">\n" +
                        "        <h3>您添加了" + num + "件商品</h3><br>\n" +
                        "        <div class=\"add-shop-cart-btn\">\n" +
                        "            <a class=\"z-index99\" href=\"UpdateCounterSvl\">继续购物</a>" +
                        "        </div>\n" +
                        "        <div class=\"add-shop-cart-btn\">\n" +
                        "            <a class=\"z-index99\" href=\"ShowCartSvl\">查看购物车</a>" +
                        "        </div>\n" +
                        "        <div class=\"add-shop-cart-btn\">\n" +
                        "            <a class=\"z-index99\" href=\"LogoutSvl\">退出</a>" +
                        "        </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "</html>");
                writer.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
