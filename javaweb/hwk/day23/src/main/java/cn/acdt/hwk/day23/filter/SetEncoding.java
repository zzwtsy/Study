package cn.acdt.hwk.day23.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 自动登录过滤器
 *
 * @author zzwtsy
 * @date 2022/11/10
 */
@WebFilter(filterName = "/SetEncoding",
        dispatcherTypes = {DispatcherType.REQUEST},
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")
        })
public class SetEncoding implements Filter {
    String encoding = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter(encoding);
    }

    @Override
    public void destroy() {
        this.encoding = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (encoding != null) {
            response.setCharacterEncoding(this.encoding);
        }
        chain.doFilter(request, response);
    }
}
