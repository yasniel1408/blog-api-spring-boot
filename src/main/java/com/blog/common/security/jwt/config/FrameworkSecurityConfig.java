package org.zenith.framework.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.zenith.framework.security.config.helper.AuthenticationExceptionHandler;
import org.zenith.framework.security.config.helper.AuthorizationExceptionHandler;
import org.zenith.framework.security.config.helper.SecurityResponseBuilder;
import org.zenith.framework.security.jwt.JwtAuthenticationFilter;
import org.zenith.framework.security.jwt.JwtAuthorizationFilter;
import org.zenith.utilities.objectmapper.config.UtilitiesObjectMapperConfig;

import static org.zenith.data.training.config.SecurityRoleNames.ROLE_ADMIN;
import static org.zenith.data.training.config.SecurityRoleNames.ROLE_SUPER_ADMIN;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@ComponentScan("org.zenith.framework.security")
@Configuration
@EnableWebSecurity
@EnableJpaAuditing
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(UtilitiesObjectMapperConfig.class)
@AllArgsConstructor
public class FrameworkSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_ENDPOINT = "/login";

    private static final String GLOBAL_URI = "/**";

    private final UserDetailsService userDetailsService;

    private final ObjectMapper defaultObjectMapper;

    private final AuthorizationExceptionHandler authorizationExceptionHandler;

    private final AuthenticationExceptionHandler authenticationExceptionHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger" + GLOBAL_URI, "/swagger-ui" + GLOBAL_URI, "/v3/api-docs" + GLOBAL_URI);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .mvcMatchers(LOGIN_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.EMAILS_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.DISCOUNTS_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.USER_REGISTRATIONS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.PUT, ServiceEndpoints.PASSWORDS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.PASSWORDS_TOKENS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.STATES_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.INDUSTRIES_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.EXAM_TYPES_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.FREE_EXAMS_ATTEMPTS_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.TRAININGS_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.FREE_EXAM_PROSPECTS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.STRIPE_PAYMENTS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.USERS_TRAININGS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.USERS_TRAININGS_BUYING_VALIDATIONS_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.DELETE, ServiceEndpoints.USERS_TRAININGS_ENDPOINT + GLOBAL_URI).hasAnyRole(ROLE_SUPER_ADMIN, ROLE_ADMIN)

                //SERVICE-ADMIN
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.QUESTIONS_ENDPOINT + GLOBAL_URI).hasAnyRole(ROLE_SUPER_ADMIN, ROLE_ADMIN)
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.QUESTIONS_ENDPOINT).hasAnyRole(ROLE_SUPER_ADMIN, ROLE_ADMIN)
                .mvcMatchers(HttpMethod.PUT,
                        ServiceEndpoints.QUESTIONS_ENDPOINT,
                        ServiceEndpoints.QUESTIONS_STATUSES_ENDPOINT,
                        ServiceEndpoints.ANSWERS_UPDATE_STATUS_ENDPOINT,
                        ServiceEndpoints.QUESTIONS_ACTIVATIONS_ENDPOINT
                ).hasAnyRole(ROLE_SUPER_ADMIN, ROLE_ADMIN)

                //SERVICE-PARSER
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.GLOSSARIES_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.CC_QUESTIONS_ENDPOINT).permitAll()

                .anyRequest().authenticated().and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), defaultObjectMapper))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().rememberMe().userDetailsService(userDetailsService)
                // Attaching the AuthenticationExceptionHandler for authentication exception handling
                .and().exceptionHandling().authenticationEntryPoint(authenticationExceptionHandler)
                // Attaching the AuthorizationExceptionHandler for authorization exception handling
                .and().exceptionHandling().accessDeniedHandler(authorizationExceptionHandler);
    }

    /**
     * Tells Spring Security to initialize the {@link AuthenticationExceptionHandler} class that will handle all the authentication (401) exceptions thrown by the {@link org.zenith.framework.security.service.AppUserDetailsService#loadUserByUsername(String)} method
     *
     * @return AuthenticationEntryPoint
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(SecurityResponseBuilder securityResponseBuilder) {
        return new AuthenticationExceptionHandler(securityResponseBuilder);
    }

    /**
     * Initializes the {@link AuthorizationExceptionHandler} class that will handle any authorization (403) errors thrown.
     *
     * @return AuthorizationExceptionHandler
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler(SecurityResponseBuilder securityResponseBuilder) {
        return new AuthorizationExceptionHandler(securityResponseBuilder);
    }

}
