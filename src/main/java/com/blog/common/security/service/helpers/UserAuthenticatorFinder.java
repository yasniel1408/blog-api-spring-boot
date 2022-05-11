package org.zenith.framework.security.service.helpers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zenith.data.training.dao.UserRepository;
import org.zenith.data.training.entity.UserEntity;

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
