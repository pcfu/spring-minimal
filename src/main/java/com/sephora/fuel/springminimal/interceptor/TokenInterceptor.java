package com.sephora.fuel.springminimal.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    // Request is intercepted BEFORE reaching the Controller
    @Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        logger.info("===== IN PRE_HANDLE =====");

        String token = ExternalTokenService.getToken();
        if (token == null) {
            response.getWriter().write("{\"error\": \"Unable to get token from external service\"}");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(503);
            return false;
        }

        request.setAttribute("token", token);
        return true;
    }

	// Response from controller is intercepted BEFORE reaching the client
	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        logger.info("===== IN POST_HANDLE =====");
    }

	// Callback AFTER request & response complete
	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {

        logger.info("===== IN AFTER_COMPLETION =====");
	}

    class ExternalTokenService {
        public static String getToken() {
            return "dummytoken";
        }
    }
}
