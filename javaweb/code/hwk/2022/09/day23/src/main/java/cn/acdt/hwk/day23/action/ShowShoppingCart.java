package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * 显示购物车商品
 *
 * @author zzwtsy
 * @date 2022-10-22
 */
@WebServlet("/ShowShoppingCart")
public class ShowShoppingCart extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<String> carts = (ArrayList<String>) request.getSession().getAttribute("carts");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" href=\"./css/style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./css/ShowShoppingCart.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./css/welcome.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://at.alicdn.com/t/c/font_3735743_gi1bux4iwbg.css\">\n" +
                "    <link href=\"https://lf3-cdn-tos.bytecdntp.com/cdn/expire-1-M/bootstrap/4.6.1/css/bootstrap.css\" type=\"text/css\"\n" +
                "          rel=\"stylesheet\"/>\n" +
                "    <link href=\"https://lf9-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/css/all.min.css\" type=\"text/css\"\n" +
                "          rel=\"stylesheet\"/>\n" +
                "    <script src=\"https://lf6-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/js/all.js\"\n" +
                "            type=\"application/javascript\"></script>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div class=\"login\">\n" +
                "    <form class=\"z-index99\" method=\"post\">\n" +
                "        <div class=\"row row-cols-4\">\n");
        for (String o : carts) {
            writer.println("<div class=\"z-index99 login small-box goods-cart col\">");
            writer.println("<label class=\"z-index99\">");
            if ("电视".equals(o)) {
                writer.println("<i class=\"iconfont icon-dianshi\"></i>");
            }
            if ("电话".equals(o)) {
                writer.println("<i class=\"iconfont icon-31dianhua\"></i>");
            }
            if ("微波炉".equals(o)) {
                writer.println("<i class=\"iconfont icon-weibolu\"></i>");
            }
            if ("冰箱".equals(o)) {
                writer.println("<i class=\"iconfont icon-bingxiang\"></i>");
            }
            if ("洗衣机".equals(o)) {
                writer.println("<i class=\"iconfont icon-xiyiji\"></i>");
            }
            writer.println("<br>");
            writer.println(o);
            writer.println("</label></div>");
        }
        writer.println("</div>\n" +
                "        <div class=\"add-shop-cart-btn\">\n" +
                "            <a class=\"z-index99\" href=\"UpdateCounter\">继续购物</a>" +
                "        </div>\n" +
                "        <div class=\"add-shop-cart-btn\">\n" +
                "            <a class=\"z-index99\" href=\"Logout\">退出</a>" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
        writer.close();
    }
}
