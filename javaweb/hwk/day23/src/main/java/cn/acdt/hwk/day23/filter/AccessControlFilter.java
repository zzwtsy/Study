package cn.acdt.hwk.day23.filter;

import cn.acdt.hwk.day23.action.WelcomeSvl;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 *
 * @author zzwtsy
 * @date 2022/11/10
 */
@Log4j2
@WebFilter(filterName = "LoginFilter",
        urlPatterns = {"/WelcomeSvl", "/LogoutSvl", "/ShowCartSvl",
                "/WelcomeSvl", "/CartStatusSvl", "/welcome.jsp",
                "/welcome.jsp"}
)

public class AccessControlFilter implements Filter {
    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //过滤没有登录的情况
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("name") == null) {
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
                                        "您还没有登陆，3秒后返回登录页面"
                                    ],
                                    typeSpeed: 80,   //打印速度
                                    loop: false,      //是否循环
                                };
                                var typed = new Typed('#typed', options);
                            </script>
                        </body>

                        </html>""");
                session.invalidate();
                resp.setHeader("Refresh", "4.4;URL=LoginSvl");
                log.info("用户未登陆，跳转登陆界面");
                writer.flush();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            return;
        } else {
            new WelcomeSvl();
            log.info("用户已登陆，跳转欢迎界面");
        }
        chain.doFilter(request, response);
    }
}
