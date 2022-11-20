package cn.acdt.hwk.day23.action;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注销svl
 *
 * @author zzwtsy
 * @since 2022-10-27
 */
@Log4j2
@WebServlet("/LogoutSvl")
public class LogoutSvl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("""
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
                                    "正在退出，3秒后返回登录页面"
                                ],
                                typeSpeed: 80,   //打印速度
                                loop: false,      //是否循环
                            };
                            var typed = new Typed('#typed', options);
                        </script>
                    </body>

                    </html>""");
            HttpSession session = request.getSession();
            session.invalidate();
            response.setHeader("Refresh", "4.4;URL=LoginSvl");
            log.info("用户已退出登陆");
            writer.flush();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
