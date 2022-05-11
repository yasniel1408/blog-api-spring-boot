package com.blog.common.security.service;

import com.blog.common.security.model.AppUser;
import com.blog.common.security.model.IAppUser;
import com.blog.user.dao.UserEntity;
import com.blog.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
