package org.zenith.framework.exception.helper;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.zenith.framework.exception.model.MessageKey;

import java.util.Locale;

/**
 * The type Error message property reader.
 */
@Component
@AllArgsConstructor
public class ErrorMessagePropertyReader {

    /**
     * Contains the error messages loaded from ExceptionConfig that read from error-messages.properties.
     */
    private final MessageSource errorMessageSource;

    /**
     * Get the error message from the error-messages.properties.
     *
     * @param messageKey containing the error code
     * @param args       to be set in the error message
     * @return the error message from the error-messages.properties
     */
    public String read(MessageKey messageKey, String... args) {
        return errorMessageSource.getMessage(messageKey.name(), args, Locale.getDefault());
    }
}
