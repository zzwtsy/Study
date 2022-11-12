package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.UpdateCounter;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 欢迎
 * Servlet implementation class WelcomeSvl
 *
 * @author zzwtsy
 * @date 2022/10/27
 */
@Log4j2
@WebServlet("/WelcomeSvl")
public class WelcomeSvl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = this.getServletContext();
        new UpdateCounter().updateCounter(servletContext);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
        log.info("跳转欢迎界面");
    }
}
