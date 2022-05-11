package com.blog.common.security.jwt;

import com.blog.common.exception.model.MessageKey;
import com.blog.common.security.model.AppUser;
import com.blog.user.dao.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import static com.blog.common.security.jwt.JwtAuthorizationFilter.*;

/**
 * The type Jwt authentication filter, allow authentication and generate the security token.
 */
@AllArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    static final String SECRET = "Z3nith2@21*";

    private final AuthenticationManager authenticationManager;

    private final ObjectMapper defaultObjectMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = null;
        UserEntity userEntity;
        try {
            //Here we get the username and password from the request, and we deserialize it into an UserEntity.
            userEntity = defaultObjectMapper.readValue(request.getInputStream(), UserEntity.class);
        } catch (IOException ioException) {
            throw new BadCredentialsException("IOException thrown while trying to serialize UserEntity", ioException);
        }
        if (userEntity != null) {

            request.setAttribute(HEADER_MESSAGE, "BAD CREDENTIALS");
            request.setAttribute(DEVELOPER_MESSAGE, "Incorrect user or password");
            request.setAttribute(USER_MESSAGE_KEY, MessageKey.AUTHENTICATION_ERROR);

            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userEntity.getEmail().toLowerCase(),
                            userEntity.getPassword()));
        }
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {

        AppUser appUser = (AppUser) authentication.getPrincipal();
        appUser.setPassword(null); //here it is passed to null so as not to pass the password in the token

        LocalTime currentLocalTime = LocalTime.now();
        LocalDate currentLocalDate = LocalDate.now();
        Date currentDate = Date.from(currentLocalDate.atTime(currentLocalTime).atZone(ZoneId.systemDefault()).toInstant());

        LocalDate expirationLocalDate = currentLocalDate.plusDays(1);
        Date expirationDate = Date.from(expirationLocalDate.atTime(currentLocalTime).atZone(ZoneId.systemDefault()).toInstant());

        String token = Jwts.builder().setSubject(appUser.getEmail())
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .claim("appUser", appUser)
                .compact();

        response.addHeader(JwtAuthorizationFilter.AUTHORIZATION, JwtAuthorizationFilter.BEARER + token);
    }

}
