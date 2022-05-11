package com.blog.common.security.service.helpers;

import com.blog.user.dao.UserEntity;
import com.blog.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * UserAuthenticatorFinder finds a user entity authenticator.
 */
@Component
@AllArgsConstructor
public class UserAuthenticatorFinder {

    private final SecurityAppUserFinder securityAppUserFinder;

    private final UserRepository userRepository;

    /**
     * Find a user entity authenticator.
     *
     * @return {@link UserEntity} the user entity
     */
    public UserEntity find() {
        var iAppUser = securityAppUserFinder.find();
        return userRepository.findById(iAppUser.getId()).orElse(null);
    }
}
