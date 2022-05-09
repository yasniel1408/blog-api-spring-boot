package com.blog.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * The type Swagger config.
 */
@Schema(hidden = true)
@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Blog APIs", version = "v1.0.0",
                description = "Blog APIs.",
                contact = @Contact(
                        name = "Inf-Soft Team",
                        email = "yasnielfajardoegues1408@gmail.com"
                )),
        security = @SecurityRequirement(name = "Blog Swagger UI security schema")
)
@SecurityScheme(
        name = "Blog Swagger UI security schema",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

}
