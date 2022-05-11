package com.blog.common.exception;


import com.blog.common.exception.model.MessageKey;

/**
 * The type Application client exception.
 */
public class ApplicationClientException extends RuntimeException {

    /**
     * Used to provide a human readable message to the developer to understand a recoverable solution to the error.
     */
    private final String developerMessage;

    /**
     * Error code enum containing the specific error codes, corresponding to error-error-messages.properties.
     */
    private final MessageKey messageKey;

    /**
     * Optional arguments used to be passed to the error-error-messages.properties.
     */
    private final String[] messageArguments;

    /**
     * Gets developer message.
     *
     * @return the developer message
     */
    public String getDeveloperMessage() {
        return developerMessage;
    }

    /**
     * Gets message key.
     *
     * @return the message key
     */
    public MessageKey getMessageKey() {
        return messageKey;
    }

    /**
     * Get message arguments string [ ].
     *
     * @return the string [ ]
     */
    public String[] getMessageArguments() {
        return messageArguments;
    }

    /**
     * Instantiates a new Application client exception.
     *
     * @param developerMessage the developer message
     * @param messageKey       the message key
     * @param messageArguments the message arguments
     */
    public ApplicationClientException(String developerMessage, MessageKey messageKey, String... messageArguments) {
        super();
        this.developerMessage = developerMessage;
        this.messageKey = messageKey;
        this.messageArguments = messageArguments;
    }
}
