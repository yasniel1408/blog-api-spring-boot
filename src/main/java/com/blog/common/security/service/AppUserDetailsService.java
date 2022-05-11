package org.zenith.framework.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.zenith.data.training.dao.UserRepository;
import org.zenith.data.training.entity.UserEntity;
import org.zenith.framework.security.model.AppUser;
import org.zenith.framework.security.model.IAppUser;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public IAppUser loadUserByUsername(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);

        IAppUser appUser = null;
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if (userEntity.isEnabled()) {
                appUser = AppUser.build(userEntity);
            }
        }
        return appUser;
    }

}
