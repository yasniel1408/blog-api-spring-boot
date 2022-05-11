package com.blog.user.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * {@link org.zenith.data.training.entity.UserVerificationTokenEntity} class represents the domain of the user_password_reset_token table.
 */
@Entity
@Table(name = "user_password_reset_token")
@Getter
@Setter
public class UserPasswordResetTokenEntity extends BaseTokenEntity {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UserPasswordResetTokenEntity that = (UserPasswordResetTokenEntity) o;

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
