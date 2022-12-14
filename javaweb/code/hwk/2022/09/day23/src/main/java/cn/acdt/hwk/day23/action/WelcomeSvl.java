package cn.acdt.hwk.day23.action;

import cn.acdt.hwk.day23.tools.UpdateCounter;

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
@WebServlet("/WelcomeSvl")
public class WelcomeSvl extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = this.getServletContext();
        new UpdateCounter().updateCounter(servletContext);
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            session.setAttribute("name", "false");
        }
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
