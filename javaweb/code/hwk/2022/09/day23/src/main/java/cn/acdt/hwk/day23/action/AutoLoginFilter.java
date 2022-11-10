package cn.acdt.hwk.day23.action;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 自动登录过滤器
 *
 * @author zzwtsy
 * @date 2022/11/10
 */
@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
