package com.blog.user.repository;

import com.blog.user.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * {@link UserRepository} is the dao repository to handle the queries for the app_user table.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find a {@link UserEntity} given its email.
     * <p>It is used in the UserRegistrationService, PasswordTokenResetService and AppUserDetailsService</p>
     *
     * @param email {@link String} the email
     * @return {@link Optional}<{@link UserEntity}> the optional app user entity
     */
    Optional<UserEntity> findByEmail(String email);

    /**
     * Returns if a {@link UserEntity} exists by email
     * <p>It is used in the ChangePasswordRequestServiceRequestValidator and UserRepository</p>
     *
     * @param email {@link String} the email
     * @return {@code boolean} true or false
     */
    boolean existsByEmail(String email);

    /**
     * Returns if a {@link UserEntity} exists by email and has training es true
     * <p>It is used in the BaseUserServiceRequestValidator</p>
     *
     * @param email {@link String} the email
     * @return {@code boolean} true or false
     */
    boolean existsByEmailAndBoughtTrainingsIsTrue(String email);

    /**
     * Returns if a {@link UserEntity} exists by email and id combination
     * <p>It is used in the BaseUserServiceRequestValidator</p>
     *
     * @param email {@link String} the email
     * @param id    {@link Long} the id
     * @return {@code boolean} true or false
     */
    boolean existsByEmailAndIdIsNot(String email, Long id);

}
