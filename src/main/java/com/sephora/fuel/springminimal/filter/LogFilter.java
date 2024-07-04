package com.sephora.fuel.springminimal.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

@Component
public class LogFilter extends OncePerRequestFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("===== IN LOG_FILTER =====");

        // log request
        CachedHttpServletRequest cachedRequest = new CachedHttpServletRequest(request);
        LOGGER.info("RECEIVED {} {}?{}", cachedRequest.getMethod(), cachedRequest.getRequestURL(), cachedRequest.getQueryString());
        LOGGER.info("REQUEST DATA: " + IOUtils.toString(cachedRequest.getInputStream(), StandardCharsets.UTF_8));

        filterChain.doFilter(cachedRequest, response);

        // log response
    }
}
