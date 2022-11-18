package cn.acdt.hwk.day23.action;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 孟繁兴
 */
@Log4j2
@WebServlet(urlPatterns = "/CartStatusSvl")
public class CartStatusSvl extends HttpServlet {
    final String str1 = """
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <script src="https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-M/typed.js/2.0.12/typed.min.js"
                    type="application/javascript"></script>
                <title>Document</title>
                <style>
                    body {
                        padding: 0;
                        margin: 0;
                        color: #0066cc;
                        background-color: #99CCFF !important;            display: flex;
                        height: 100vh;
                        justify-content: center;
                        align-items: center;
                        font-size: 24px;
                    }
                </style>
            </head>

            <body>
                <span id="typed"></span>
                <script type="text/javascript">
                    var options = {
                        strings: [
                            "您还没有登录，请先登录，3秒后返回登录页面"
                        ],
                        typeSpeed: 80,   //打印速度
                        loop: false,      //是否循环
                    };
                    var typed = new Typed('#typed', options);
                </script>
            </body>

            </html>""";

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
            log.info("用户已登陆");
        }
        String user = (String) session.getAttribute("name");
        if (user == null) {
            log.info("用户未登陆");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(str1);
            response.setHeader("Refresh", "5.1;URL=LoginSvl");
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
            session.setAttribute("addGoodsNum", num);
            session.setAttribute("addGoodsTotal", carts.size());
            session.setAttribute("carts", carts);
            try {
                request.getRequestDispatcher("cart-status.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
