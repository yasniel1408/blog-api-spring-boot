package com.blog.user.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * {@link UserVerificationTokenEntity} class represents the domain of the user_verification_token table.
 */
@Entity
@Table(name = "user_verification_token")
@Getter
@Setter
public class UserVerificationTokenEntity extends BaseTokenEntity {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UserVerificationTokenEntity that = (UserVerificationTokenEntity) o;

        if (!Objects.equals(getUserEntity(), that.getUserEntity())) {
            return false;
        }
        return Objects.equals(getToken(), that.getToken());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getUserEntity());
        result = 31 * result + (Objects.hashCode(getToken()));
        return result;
    }
}
