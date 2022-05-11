package org.zenith.framework.security.config;

/**
 * The type Service endpoints.
 */
public class ServiceEndpoints {

    private ServiceEndpoints() {
    }

    /**
     * The constant BASE_ENDPOINT.
     */
    private static final String BASE_ENDPOINT = "/zenith";

    /**
     * The constant BASE_PARSER_ENDPOINT.
     */
    private static final String BASE_PARSER_ENDPOINT = "/parser";

    /**
     * The constant VERSION1 to be reused by endpoints
     */
    private static final String VERSION1 = "/v1";

    /**
     * /users ENDPOINT
     */
    public static final String USERS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/users";

    /**
     * /emails ENDPOINT
     */
    public static final String EMAILS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/emails";

    /**
     * /categories ENDPOINT
     */
    public static final String CATEGORIES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/categories";

    //** BEGINNING OF PRACTICE EXAMS ENDPOINTS **//

    /**
     * Reused constant ATTEMPTS
     */
    private static final String ATTEMPTS = "/attempts";

    /**
     * /practice_exams/attempts ENDPOINT
     */
    public static final String PRACTICE_EXAMS_ATTEMPTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/practice_exams" + ATTEMPTS;

    /**
     * Reused constant RESULTS
     */
    private static final String RESULTS = "/results";

    /**
     * /practice_exams/attempts/results ENDPOINT
     */
    public static final String PRACTICE_EXAM_ATTEMPT_RESULTS_ENDPOINT = PRACTICE_EXAMS_ATTEMPTS_ENDPOINT + RESULTS;

    //** END OF PRACTICE EXAMS ENDPOINTS **//

    //** BEGINNING OF PRACTICE EXAMS BY CATEGORY ENDPOINTS **//

    /**
     * Reused constant PRACTICES_EXAMS_BY_CATEGORIES
     */
    private static final String PRACTICE_EXAMS_BY_CATEGORIES = "/practice_exams_by_categories";

    /**
     * /practice_exams_by_categories/attempts ENDPOINT
     */
    public static final String PRACTICE_EXAM_BY_CATEGORIES_ATTEMPTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + PRACTICE_EXAMS_BY_CATEGORIES + ATTEMPTS;

    /**
     * /training_exams_by_categories/attempts/results ENDPOINT
     */
    public static final String TRAINING_EXAM_BY_CATEGORIES_ATTEMPTS_RESULTS_ENDPOINT = PRACTICE_EXAM_BY_CATEGORIES_ATTEMPTS_ENDPOINT + RESULTS;

    //** END OF PRACTICE EXAMS BY CATEGORY ENDPOINTS **//

    //** BEGINNING OF SIMULATED EXAMS ENDPOINTS **//

    /**
     * /simulated_exam_attempts ENDPOINT.
     */
    public static final String SIMULATED_EXAMS_ATTEMPTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/simulated_exams" + ATTEMPTS;

    /**
     * /simulated_exams/attempts/results ENDPOINT.
     */
    public static final String SIMULATED_EXAMS_ATTEMPTS_RESULTS_ENDPOINT = SIMULATED_EXAMS_ATTEMPTS_ENDPOINT + RESULTS;

    //** END OF SIMULATED EXAMS ENDPOINTS **//

    //** BEGINNING OF FLASHCARDS ENDPOINTS **//

    /**
     * /flashcards/attempts ENDPOINT
     */
    public static final String FLASHCARD_ATTEMPTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/flashcards" + ATTEMPTS;

    //** END OF FLASHCARDS ENDPOINTS **//

    /**
     * /trainings ENDPOINT
     */
    private static final String TRAININGS = "/trainings";

    //** BEGINNING OF USERS ENDPOINTS **//

    /**
     * /users/registrations ENDPOINT - PermitAll
     */
    public static final String USER_REGISTRATIONS_ENDPOINT = USERS_ENDPOINT + "/registrations";

    /**
     * /users/trainings ENDPOINT
     */
    public static final String USERS_TRAININGS_ENDPOINT = USERS_ENDPOINT + TRAININGS;

    /**
     * /users/trainings/buying_validations ENDPOINT
     */
    public static final String USERS_TRAININGS_BUYING_VALIDATIONS_ENDPOINT = USERS_TRAININGS_ENDPOINT + "/buying_validations";

    /**
     * /users/industries_states_exam_types/categories ENDPOINT
     */
    public static final String USERS_TRAININGS_CATEGORIES_ENDPOINT = USERS_TRAININGS_ENDPOINT + "/categories";

    //** END OF USERS ENDPOINTS **//

    /**
     * /feedbacks ENDPOINT
     */
    public static final String FEEDBACK_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/feedbacks";

    /**
     * /feedbacks_types ENDPOINT
     */
    public static final String FEEDBACK_TYPES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/feedback_types";

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
     * /questions ENDPOINT
     */
    public static final String QUESTIONS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/questions";

    /**
     * /questions statuses ENDPOINT
     */
    public static final String QUESTIONS_STATUSES_ENDPOINT = QUESTIONS_ENDPOINT + "/statuses";

    /**
     * /questions activations ENDPOINT - used to activate questions.
     */
    public static final String QUESTIONS_ACTIVATIONS_ENDPOINT = QUESTIONS_ENDPOINT + "/activations";

    /**
     * /questions_sources ENDPOINT
     */
    public static final String QUESTIONS_SOURCES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/questions_sources";

    /**
     * /question_answer_update_statuses ENDPOINT
     */
    public static final String QUESTION_ANSWER_UPDATE_STATUSES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/question_answer_update_statuses";

    /**
     * /states ENDPOINT
     */
    public static final String STATES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/states";

    /**
     * /industries ENDPOINT
     */
    public static final String INDUSTRIES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/industries";

    /**
     * /exam_types ENDPOINT
     */
    public static final String EXAM_TYPES_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/exam_types";

    /**
     * /trainings ENDPOINT - By definition is the industry state exam type and price combination.
     */
    public static final String TRAININGS_ENDPOINT = BASE_ENDPOINT + VERSION1 + TRAININGS;

    /**
     * /stripe_payments ENDPOINT
     */
    public static final String STRIPE_PAYMENTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/stripe_payments";

    /**
     * /answers/update_statuses ENDPOINT
     */
    public static final String ANSWERS_UPDATE_STATUS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/answers/update_statuses";

    private static final String FREE_EXAMS = "/free_exams";

    /**
     * /free_exams/attempts ENDPOINT.
     */
    public static final String FREE_EXAMS_ATTEMPTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + FREE_EXAMS + ATTEMPTS;

    /**
     * /free_exam_prospects ENDPOINT
     */
    public static final String FREE_EXAM_PROSPECTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/free_exam_prospects";


    /**
     * /samples ENDPOINT
     */
    public static final String EXAMS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/exams";


    /**
     * /samples ENDPOINT
     */
    public static final String DISCOUNTS_ENDPOINT = BASE_ENDPOINT + VERSION1 + "/discounts";


    //** BEGINNING OF PARSER ENDPOINTS **//

    /**
     * /cc_questions ENDPOINT
     */
    public static final String CC_QUESTIONS_ENDPOINT = BASE_PARSER_ENDPOINT + VERSION1 + "/cc_questions";

    /**
     * /glossaries ENDPOINT
     */
    public static final String GLOSSARIES_ENDPOINT = BASE_PARSER_ENDPOINT + VERSION1 + "/glossaries";

    //** END BEGINNING OF PARSER ENDPOINTS **//

}
