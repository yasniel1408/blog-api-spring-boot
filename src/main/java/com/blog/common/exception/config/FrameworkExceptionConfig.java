package org.zenith.framework.exception.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * The type Framework exception config.
 */
@Configuration
@ComponentScan(basePackages = "org.zenith.framework.exception")
public class FrameworkExceptionConfig {

    private static final String ERROR_MESSAGES_FILE_NAME = "error-messages";

    /**
     * Error message source message source.
     *
     * @return the message source
     */
    @Bean
    public MessageSource errorMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:" + ERROR_MESSAGES_FILE_NAME);
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

}
