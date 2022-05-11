package com.blog.common.security.service.helpers;

import com.blog.common.security.model.AppUser;
import com.blog.common.security.model.IAppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

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
