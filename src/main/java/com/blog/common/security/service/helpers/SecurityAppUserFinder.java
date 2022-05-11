package org.zenith.framework.security.service.helpers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.zenith.framework.security.model.AppUser;
import org.zenith.framework.security.model.IAppUser;

@Component
@AllArgsConstructor
public class SecurityAppUserFinder {

    private final SecurityAuthenticationFinder securityAuthenticationFinder;

    public IAppUser find() {
        IAppUser appUser = null;
        Authentication authentication = securityAuthenticationFinder.find();

        Object principal = authentication.getPrincipal();
        if (principal != null && !"anonymousUser".equals(principal)) {
            appUser = (AppUser) principal;
        }
        return appUser;
    }

}
