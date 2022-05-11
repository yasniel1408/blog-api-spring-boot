package com.blog.user.repository;

import com.blog.user.dao.UserVerificationTokenEntity;
import org.springframework.stereotype.Repository;

/**
 * {@link UserVerificationTokenRepository} is the dao repository to handle the queries for the user_verification_token table.
 */
@Repository
public interface UserVerificationTokenRepository extends BaseSecurityTokenRepository<UserVerificationTokenEntity> {

}
