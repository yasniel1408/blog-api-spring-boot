package org.zenith.framework.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface IAppUser extends UserDetails {

    Long getId();

    String getEmail();

    String getFirstName();

    String getLastName();

    @Override
    Collection<GrantedAuthority> getAuthorities();

    @Override
    default String getUsername() {
        return getEmail();
    }


}
