package org.zenith.data.training.dao;

import org.springframework.stereotype.Repository;
import org.zenith.data.training.entity.UserVerificationTokenEntity;

/**
 * {@link UserVerificationTokenRepository} is the dao repository to handle the queries for the user_verification_token table.
 */
@Repository
public interface UserVerificationTokenRepository extends BaseSecurityTokenRepository<UserVerificationTokenEntity> {

}
