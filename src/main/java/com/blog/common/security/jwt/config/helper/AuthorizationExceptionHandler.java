package org.zenith.framework.security.config.helper;

import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.zenith.framework.exception.model.MessageKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <code>AuthorizationExceptionHandler</code> handle the exceptions thrown by {@link org.zenith.framework.security.service.AppUserDetailsService} class
 * Mainly all the authorization related exceptions (runtime ones) will fall in here
 */
@Component
@AllArgsConstructor
public class AuthorizationExceptionHandler implements AccessDeniedHandler {

    private static final String AUTHORIZATION_ERROR_HEADER_MESSAGE = "AUTHORIZATION ERROR";

    private static final String AUTHORIZATION_ERROR_DEVELOPER_MESSAGE = "The GUID passed in the HTTP headers is linked to an LDAP Group Access that does not have access to this API.";

    private final SecurityResponseBuilder securityResponseBuilder;

    /**
     * Creates and sends the error messages as a response for any Authorization Error (403).
     *
     * @param request               the request
     * @param response              the response
     * @param accessDeniedException the access denied  exception
     * @throws IOException when response write fails
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        securityResponseBuilder.build(response, MessageKey.AUTHORIZATION_ERROR,
                AUTHORIZATION_ERROR_HEADER_MESSAGE, AUTHORIZATION_ERROR_DEVELOPER_MESSAGE, HttpServletResponse.SC_FORBIDDEN);
    }
}
