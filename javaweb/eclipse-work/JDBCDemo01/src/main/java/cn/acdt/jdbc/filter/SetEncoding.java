package cn.acdt.jdbc.filter;

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
 * 
 * @author 孟繁兴
 * @date 2022/11/17
 */
@WebFilter(urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
    initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class SetEncoding extends HttpFilter implements Filter {
    private String encodingString = null;

    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        if (encodingString != null) {
            encodingString = null;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        request.setCharacterEncoding(encodingString);
        response.setCharacterEncoding(encodingString);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        encodingString = fConfig.getInitParameter("encoding");
    }

}
