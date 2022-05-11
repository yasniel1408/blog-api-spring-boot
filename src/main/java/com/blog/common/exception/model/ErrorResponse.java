package org.zenith.framework.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Error response.
 */
@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String headerMessage;

    private String message;

    private String developerMessage;

}

