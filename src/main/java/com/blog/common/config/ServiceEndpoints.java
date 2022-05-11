package com.blog.common.config;

/**
 * The type Service endpoints.
 */
public class ServiceEndpoints {

    /**
     * The constant BASE_ENDPOINT.
     */
    private static final String BASE_ENDPOINT = "/infsoft";


    /**
     * The constant VERSION1 to be reused by endpoints
     */
    private static final String VERSION1 = "/v1";

    /**
     * Reused PASSWORD constant
     */
    private static final String PASSWORDS = "/passwords";

    /**
     * /passwords ENDPOINT - PermitAll
     */
    public static final String PASSWORDS_ENDPOINT = BASE_ENDPOINT + VERSION1 + PASSWORDS;


    /**
     * This endpoint is executed when a user requests a password change. A Universal Unique Identifier (UUID) is generated,
     * stored in the database and an email is sent to the user with this identifier concatenated to the url to
     * change the password
     * /passwords/tokens ENDPOINT - PermitAll
     */
    public static final String PASSWORDS_TOKENS_ENDPOINT = PASSWORDS_ENDPOINT + "/tokens";

    /**
     * /users ENDPOINT
     */
    public static final String USERS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/users";


    /**
     * /users/registrations ENDPOINT - PermitAll
     */
    public static final String USER_REGISTRATIONS_ENDPOINT = USERS_ENDPOINT + "/registrations";


    public static final String EMAILS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/emails";


    public static final String CATEGORY_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/categories";

    public static final String POST_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/posts";
}
