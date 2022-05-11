package com.blog.user.dao;

import com.blog.common.dao.BaseAnonymousEntityDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract class for base token.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTokenEntity extends BaseAnonymousEntityDao {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NaturalId
    private UserEntity userEntity;

    @Column(name = "token")
    @NaturalId
    private String token;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "used")
    private boolean used;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        BaseTokenEntity that = (BaseTokenEntity) o;

        if (!Objects.equals(userEntity, that.userEntity)) {
            return false;
        }
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(userEntity);
        result = 31 * result + (Objects.hashCode(token));
        return result;
    }
}
