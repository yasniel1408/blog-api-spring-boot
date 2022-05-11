package org.zenith.framework.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.zenith.data.training.entity.RoleEntity;
import org.zenith.data.training.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class AppUser implements IAppUser {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Collection<GrantedAuthority> authorities;

    public static IAppUser build(UserEntity userEntity) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity roleEntity : userEntity.getRoleEntities()) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return new AppUser(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getFirstName(), userEntity.getLastName(), authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
