package org.zenith.framework.security.service.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationFinder {

    public Authentication find() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = null;
        if (securityContext != null) {
            authentication = securityContext.getAuthentication();
        }
        return authentication;
    }
}
