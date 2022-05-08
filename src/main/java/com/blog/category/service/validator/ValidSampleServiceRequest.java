package com.blog.category.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * ValidSampleServiceRequest is the annotation that triggers the validation to happen on the Sample Manager Service Request.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryManagerServiceRequestValidator.class)
public @interface ValidSampleServiceRequest {

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
