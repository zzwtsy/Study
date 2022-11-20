package cn.acdt.hwk.day23.action;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * 显示购物车商品
 *
 * @author zzwtsy
 * @since 2022-10-22
 */
@Log4j2
@WebServlet("/ShowCartSvl")
public class ShowCartSvl extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> carts = (ArrayList<String>) request.getSession().getAttribute("carts");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("""
                    <html>
                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <link rel="stylesheet" href="./css/style.css">
                        <link rel="stylesheet" href="./css/ShowCartSvl.css">
                        <link rel="stylesheet" href="./css/welcome.css">
                        <link rel="stylesheet" href="https://at.alicdn.com/t/c/font_3735743_gi1bux4iwbg.css">
                        <link href="https://lf3-cdn-tos.bytecdntp.com/cdn/expire-1-M/bootstrap/4.6.1/css/bootstrap.css" type="text/css"
                              rel="stylesheet"/>
                        <link href="https://lf9-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/css/all.min.css" type="text/css"
                              rel="stylesheet"/>
                        <script src="https://lf6-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/js/all.js"
                                type="application/javascript"></script>
                        <title>Document</title>
                    </head>

                    <body>
                    <div class="login">
                        <form class="z-index99" method="post">
                        <div class="container">
                            <div class="row">
                    """);
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
            writer.println("""
                    </div>
                            <div class="add-shop-cart-btn">
                                <a class="z-index99" href="WelcomeSvl">继续购物</a>        </div>
                            <div class="add-shop-cart-btn">
                                <a class="z-index99" href="LogoutSvl">退出</a>        </div>
                        </form>
                        </div>
                    </div>
                    </body>
                    </html>""");
            writer.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
