package cn.acdt.hwk.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * @author zzwtsy
 * @date 2022-11-10
 */
@WebFilter(
        dispatcherTypes = {DispatcherType.REQUEST},
        urlPatterns = {"/AutoLoginSvl"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")
        })
public class CharterEncodingFilter extends HttpFilter implements Filter {
    protected String encoding;

    @Override
    public void destroy() {
        this.encoding = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (this.encoding != null) {
            request.setCharacterEncoding(this.encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) {
        this.encoding = fConfig.getInitParameter("encoding");
    }
}
