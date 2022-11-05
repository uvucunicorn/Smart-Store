package com.unicorn.filter;


import com.alibaba.fastjson.JSON;
import com.unicorn.common.BaseContext;
import com.unicorn.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本次请求的url
        String requestURI = request.getRequestURI();


        //定义不需要处理的请求
        String[] urls = new String[]{
                "/favicon.ico",
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/common/**"
                ,"/front/**"
                ,"/user/login"//用户登录
                , "/user/sendMsg"//移动端发送短信


        };

        boolean check = check(urls, requestURI);
        if (check) {
            filterChain.doFilter(request, response);
            log.info("1请求：{},放行", requestURI);
            return;
        }

        //判断登陆状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("employee") != null) {
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
//            Long id = Thread.currentThread().getId();
            filterChain.doFilter(request, response);
//            log.info("请求：{},放行",requestURI);
            return;
        }

        if (request.getSession().getAttribute("user") != null) {
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request, response);
            return;
        }
            log.info("用户未登录");
            //如果未登录，则返回登陆结果，通过输出流方式向客户端响应数据
            response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
            log.info("2请求：{},不放行", requestURI);
            return;
        }


    public boolean check(String[] urls, String requestURL) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURL);
            if (match) {
                return true;
            }
        }
        return false;
    }

}
