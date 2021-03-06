package com.blog.common.security.config.helper;

import com.blog.common.exception.helper.ErrorMessagePropertyReader;
import com.blog.common.exception.model.ErrorResponse;
import com.blog.common.exception.model.MessageKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <code>SecurityResponseBuilder</code> builds the response for the Exception handlers
 *
 * @author rzeng
 */
@Component
@AllArgsConstructor
public class SecurityResponseBuilder {

    private final ObjectMapper objectMapper;

    private final ErrorMessagePropertyReader errorMessagePropertyReader;

    /**
     * Builds the error response for the given error
     *
     * @param response         the http servlet response to set
     * @param messageKey       the error code
     * @param headerMessage    the header message
     * @param developerMessage the developer message
     * @param statusCode       the http status code
     * @throws IOException when writer fails to write
     */
    void build(HttpServletResponse response, MessageKey messageKey, String headerMessage, String developerMessage, int statusCode) throws IOException {
        if (!response.isCommitted() && messageKey != null ) {

            ErrorResponse errorResponse = new ErrorResponse(headerMessage, errorMessagePropertyReader.read(messageKey), developerMessage);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(statusCode);
            try (PrintWriter printWriter = response.getWriter()) {
                printWriter.write(objectMapper.writeValueAsString(errorResponse));
            }
        }
    }
}
