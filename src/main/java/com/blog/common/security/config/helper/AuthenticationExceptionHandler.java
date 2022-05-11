package com.blog.common.security.config.helper;

import com.blog.common.exception.model.MessageKey;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.blog.common.security.config.helper.SecurityResponseBuilder;

import static com.blog.common.security.jwt.JwtAuthorizationFilter.DEVELOPER_MESSAGE;
import static com.blog.common.security.jwt.JwtAuthorizationFilter.HEADER_MESSAGE;
import static com.blog.common.security.jwt.JwtAuthorizationFilter.USER_MESSAGE_KEY;

/**
 * AuthenticationExceptionHandler handle all the exceptions thrown by {@link org.zenith.framework.security.service.AppUserDetailsService} class
 * Mainly all the security unexpected exceptions (runtime ones) will fall in here
 */
@Component
@AllArgsConstructor
public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {

    private final SecurityResponseBuilder securityResponseBuilder;

    /**
     * Creates and sends the error messages as a response for any Authentication Error (401).
     *
     * @param request       {@link HttpServletRequest} the http servlet request
     * @param response      {@link HttpServletResponse} the http servlet response
     * @param authException {@link AuthenticationException} the authentication exception
     * @throws IOException when response write fails
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        securityResponseBuilder.build(response,
                (MessageKey) request.getAttribute(USER_MESSAGE_KEY),
                (String) request.getAttribute(HEADER_MESSAGE),
                (String) request.getAttribute(DEVELOPER_MESSAGE),
                HttpServletResponse.SC_UNAUTHORIZED);
    }
}
