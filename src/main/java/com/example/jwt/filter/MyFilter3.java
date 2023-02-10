package com.example.jwt.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 토큰 '코스'를 만들었다고 가정 id, pw 정상적으로 들어와 로그인 완료 되면 토큰 발행.
        // 요청시마다 header의 Authorization에 value로 토큰을 가지고 옴
        // 토큰이 내가 만든 토큰이 맞는지 검사하면 됨(RSA, HS256)
        if (req.getMethod().equals("POST")) {
            System.out.println("POST RECEIVED");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);
            System.out.println("Filter 3");

            if(headerAuth.equals("COS")) {
                filterChain.doFilter(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("NOT AUTHENTICATED");
            }
        }
    }
}
