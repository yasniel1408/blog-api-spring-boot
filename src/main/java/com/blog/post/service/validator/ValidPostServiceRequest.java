package com.blog.post.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * ValidCategoryServiceRequest is the annotation that triggers the validation to happen on the Category Manager Service Request.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostManagerServiceRequestValidator.class)
public @interface ValidCactegoryServiceRequest {

    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "there was an input validation error";

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Payload class [ ].
     *
     * @return the class [ ]
     */
    Class<? extends Payload>[] payload() default {};
}
