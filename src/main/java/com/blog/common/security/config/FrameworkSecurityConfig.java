package com.blog.common.security.config;

import com.blog.common.config.ServiceEndpoints;
import com.blog.common.objectmapper.config.UtilitiesObjectMapperConfig;
import com.blog.common.security.config.helper.AuthenticationExceptionHandler;
import com.blog.common.security.config.helper.AuthorizationExceptionHandler;
import com.blog.common.security.config.helper.SecurityResponseBuilder;
import com.blog.common.security.jwt.JwtAuthenticationFilter;
import com.blog.common.security.jwt.JwtAuthorizationFilter;
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

import static com.blog.common.security.config.SecurityRoleNames.ROLE_ADMIN;
import static com.blog.common.security.config.SecurityRoleNames.ROLE_SUPER_ADMIN;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@ComponentScan("com.blog.common.security")
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
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.USER_REGISTRATIONS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.PUT, ServiceEndpoints.PASSWORDS_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.PASSWORDS_TOKENS_ENDPOINT).permitAll()

                // .hasAnyRole(ROLE_SUPER_ADMIN, ROLE_ADMIN) , .permitAll()

                //Category
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.CATEGORY_ENDPOINT+ GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.DELETE, ServiceEndpoints.CATEGORY_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.PUT, ServiceEndpoints.CATEGORY_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.CATEGORY_ENDPOINT).permitAll()

                //Post
                .mvcMatchers(HttpMethod.GET, ServiceEndpoints.POST_ENDPOINT + GLOBAL_URI).permitAll()
                .mvcMatchers(HttpMethod.POST, ServiceEndpoints.POST_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.DELETE, ServiceEndpoints.POST_ENDPOINT).permitAll()
                .mvcMatchers(HttpMethod.PUT, ServiceEndpoints.POST_ENDPOINT).permitAll()

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
