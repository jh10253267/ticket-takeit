package com.tickettakeit.global.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class LogInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long currentTime = System.currentTimeMillis();
        request.setAttribute("startTime", currentTime);

        logger.info("요청 클라이언트 IP: {}", request.getRemoteAddr());
        logger.info("요청 URI: {}", request.getRequestURI());
        logger.info("요청 시각: {}", LocalDateTime.now());
        logger.info("요청 컨트롤러 메소드: {}", handler.toString());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long currentTime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        logger.debug("총 요청 처리 시간: {}", currentTime - startTime);
    }
}
