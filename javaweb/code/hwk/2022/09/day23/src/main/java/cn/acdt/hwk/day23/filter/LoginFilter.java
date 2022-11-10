package cn.acdt.hwk.day23.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 *
 * @author zzwtsy
 * @date 2022/11/10
 */
@WebFilter(filterName = "LoginFilter",
        urlPatterns = {"/WelcomeSvl", "/welcome.jsp", "/test.jsp"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        过滤没有登录的情况
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("name") == null) {
            req.setAttribute("logErr", "请登录");
            req.getRequestDispatcher("test.jsp").forward(req, resp);
            return;
        }
        chain.doFilter(request, response);
    }
}
