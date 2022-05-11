package org.zenith.data.training.dao;

import org.springframework.stereotype.Repository;
import org.zenith.data.training.entity.UserPasswordResetTokenEntity;

/**
 * {@link UserPasswordResetTokenRepository} is the dao repository to handle the queries for the user_password_reset_token table.
 */
@Repository
public interface UserPasswordResetTokenRepository extends BaseSecurityTokenRepository<UserPasswordResetTokenEntity> {

}
