package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注销
 *
 * @author zzwtsy
 * @date 2022-10-27
 */
@WebServlet("/LogoutSvl")
public class LogoutSvl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <script src=\"https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-M/typed.js/2.0.12/typed.min.js\"\n" +
                    "        type=\"application/javascript\"></script>\n" +
                    "    <title>Document</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            padding: 0;\n" +
                    "            margin: 0;\n" +
                    "            color: #0066cc;\n" +
                    "            background-color: #99CCFF !important;" +
                    "            display: flex;\n" +
                    "            height: 100vh;\n" +
                    "            justify-content: center;\n" +
                    "            align-items: center;\n" +
                    "            font-size: 24px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "    <span id=\"typed\"></span>\n" +
                    "    <script type=\"text/javascript\">\n" +
                    "        var options = {\n" +
                    "            strings: [\n" +
                    "                \"正在退出，3秒后返回登录页面\"\n" +
                    "            ],\n" +
                    "            typeSpeed: 80,   //打印速度\n" +
                    "            loop: false,      //是否循环\n" +
                    "        };\n" +
                    "        var typed = new Typed('#typed', options);\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>");
            HttpSession session = request.getSession();
            session.invalidate();
            response.setHeader("Refresh", "4.4;URL=LoginSvl");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
