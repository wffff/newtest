package com.gogo.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/7.
 */
@RequestMapping("/")
public class FilterEncoding  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
