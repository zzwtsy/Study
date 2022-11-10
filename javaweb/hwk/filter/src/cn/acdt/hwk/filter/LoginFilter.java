package cn.acdt.hwk.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录过滤器
 *
 * @author zzwtsy
 * @date 2022-11-10
 */
@WebFilter(urlPatterns = {"/WelcomeSvl", "/welcome.jsp"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class LoginFilter extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            rep.setContentType("text/html;charset=UTF-8");
            PrintWriter out = rep.getWriter();
            out.println("您还没有登陆，3秒后返回登陆界面。。。");
            rep.setHeader("Refresh", "3;URL=AutoLoginSvl");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) {

    }

}
