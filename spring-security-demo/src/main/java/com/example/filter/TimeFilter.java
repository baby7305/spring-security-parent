package com.example.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("过滤器启动");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("接口耗时:" + (new Date().getTime() - start));
        System.out.println("过滤器结束");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
