package com.blog.common.security.service.helpers;

import com.blog.common.security.model.IAppUser;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AppUserAuditorAware implements AuditorAware<String> {

    private final SecurityAppUserFinder securityAppUserFinder;

    @Override
    public Optional<String> getCurrentAuditor() {
        IAppUser appUser = securityAppUserFinder.find();
        Optional<String> userEmail = Optional.empty();
        if (appUser != null) {
            String uncheckedEmail = appUser.getEmail();
            if (StringUtils.isNotBlank(uncheckedEmail)) {
                userEmail = Optional.of(uncheckedEmail);
            }
        }

        return userEmail;
    }
}
