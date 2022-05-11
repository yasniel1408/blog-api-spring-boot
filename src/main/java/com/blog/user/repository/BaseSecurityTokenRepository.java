package com.blog.user.repository;

import com.blog.user.dao.BaseTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * {@link BaseSecurityTokenRepository} is the base repository to handle the queries for the tokens tables.
 *
 * @param <E> the type parameter
 */
@NoRepositoryBean
public interface BaseSecurityTokenRepository<E extends BaseTokenEntity> extends JpaRepository<E, Long> {

    /**
     * Find a {@link BaseTokenEntity} given token.
     * <p>It is used in the user confirmation functionalities and in the password change</p>
     *
     * @param token {@link String} the token
     * @return {@link Optional}<{@link E}> the optional entity
     */
    Optional<E> findByToken(String token);

    /**
     * Returns if a {@link BaseTokenEntity} exists by token
     * <p>It is used in the validator of the confirm registration and the validator of the change password</p>
     *
     * @param token {@link String} the token
     * @return the boolean
     */
    boolean existsByToken(String token);

}
