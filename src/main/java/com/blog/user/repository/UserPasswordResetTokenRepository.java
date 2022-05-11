package com.blog.user.repository;

import com.blog.user.dao.UserPasswordResetTokenEntity;
import org.springframework.stereotype.Repository;

/**
 * {@link UserPasswordResetTokenRepository} is the dao repository to handle the queries for the user_password_reset_token table.
 */
@Repository
public interface UserPasswordResetTokenRepository extends BaseSecurityTokenRepository<UserPasswordResetTokenEntity> {

}
