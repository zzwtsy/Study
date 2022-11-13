package cn.acdt.hwk.day23.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 设置编码过滤器
 *
 * @author zzwtsy
 * @date 2022/11/10
 */
@Log4j2
@WebFilter(filterName = "/SetEncodingFilter",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")
        })
public class SetEncodingFilter implements Filter {
    String encoding = null;

    @Override
    public void init(FilterConfig config) {
        this.encoding = config.getInitParameter("encoding");
    }

    @Override
    public void destroy() {
        this.encoding = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (encoding != null) {
            response.setCharacterEncoding(this.encoding);
            log.info("Set Encoding");
        }
        chain.doFilter(request, response);
    }
}
