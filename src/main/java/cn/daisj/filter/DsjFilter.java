package cn.daisj.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "dsj", urlPatterns = "/*")
public class DsjFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request Filter ....");
        chain.doFilter(request, response);
        System.out.println("response Filter ....");
    }

    @Override
    public void destroy() {

    }
}
