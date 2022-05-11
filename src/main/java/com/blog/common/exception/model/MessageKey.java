package org.zenith.framework.exception.model;

/**
 * The enum Message key.
 */
public enum MessageKey {

    /**
     * Used for all of the generic 4XX series errors, including the 4XX series errors received from external providers.
     */
    GENERIC_4XX_ERROR,

    /**
     * Used for all the generic 5XX series errors. Please DO NOT use in any new ApplicationException. This is intended to be used only in the ControllersExceptionHandler class.
     */
    GENERIC_5XX_ERROR,

    /**
     * Used to validate the HTTP headers received at the HTTP layer.
     */
    MISSING_HTTP_HEADER_ERROR,

    AUTHENTICATION_ERROR,

    AUTHENTICATION_TOKEN_EXPIRED,

    AUTHORIZATION_ERROR,

    SIGNATURE_JWT_ERROR,

    MALFORMED_JWT_ERROR,

    UNSUPPORTED_JWT_ERROR,

    ILLEGAL_ARGUMENT_JWT_ERROR,

    EMAIL_ALREADY_EXISTS_ERROR,

    DISCOUNT_CODE_DOES_NOT_EXIST_ERROR
}
