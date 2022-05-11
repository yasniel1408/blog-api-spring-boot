package com.blog.common.security.service.helpers;

import com.blog.common.security.model.IAppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import static com.blog.common.security.config.SecurityRoleNames.PREFIX_ROLE;

@Component
@AllArgsConstructor
public class RoleChecker {

    private final SecurityAppUserFinder securityAppUserFinder;

    public boolean check(String roleCheck) {
        boolean hasRole = false;
        IAppUser appUser = securityAppUserFinder.find();
        for (GrantedAuthority grantedAuthority : appUser.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals(PREFIX_ROLE + roleCheck)) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }
}
