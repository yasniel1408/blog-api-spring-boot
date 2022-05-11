package com.blog.common.security.jwt;

import com.blog.common.exception.model.MessageKey;
import com.blog.common.security.model.AppUser;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Jwt authorization filter, check the authorization of the security token sent in the header of each request.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final XLogger xlogger = XLoggerFactory.getXLogger(getClass());

    public static final String HEADER_MESSAGE = "HEADER_MESSAGE";

    public static final String DEVELOPER_MESSAGE = "DEVELOPER_MESSAGE";

    public static final String USER_MESSAGE_KEY = "USER_MESSAGE";

    static final String BEARER = "Bearer ";

    static final String AUTHORIZATION = "Authorization";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        String headerAuthorization = httpServletRequest.getHeader(AUTHORIZATION);

        if (headerAuthorization != null && headerAuthorization.startsWith(BEARER)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(httpServletRequest);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;

        String tokenRequest = httpServletRequest.getHeader(AUTHORIZATION);
        if (tokenRequest != null && tokenRequest.startsWith(BEARER)) {

            String token = tokenRequest.replace(BEARER, StringUtils.EMPTY);
            Claims claims;
            try {
                claims = Jwts.parser().setSigningKey(JwtAuthenticationFilter.SECRET).parseClaimsJws(token).getBody();
            } catch (MalformedJwtException | UnsupportedJwtException | ExpiredJwtException | IllegalArgumentException | SignatureException exception) {
                String headerMessage = null;
                MessageKey userMessageKey = null;
                if (ExpiredJwtException.class.equals(exception.getClass())) {
                    headerMessage = "TOKEN EXPIRED";
                    userMessageKey = MessageKey.AUTHENTICATION_TOKEN_EXPIRED;
                } else {
                    xlogger.catching(exception);
                    if (MalformedJwtException.class.equals(exception.getClass())) {
                        headerMessage = "MALFORMED JWT";
                        userMessageKey = MessageKey.MALFORMED_JWT_ERROR;
                    } else if (UnsupportedJwtException.class.equals(exception.getClass())) {
                        headerMessage = "UNSUPPORTED JWT";
                        userMessageKey = MessageKey.UNSUPPORTED_JWT_ERROR;
                    } else if (IllegalArgumentException.class.equals(exception.getClass())) {
                        headerMessage = "ILLEGAL ARGUMENT JWT";
                        userMessageKey = MessageKey.ILLEGAL_ARGUMENT_JWT_ERROR;
                    } else if (SignatureException.class.equals(exception.getClass())) {
                        headerMessage = "Signature Exception";
                        userMessageKey = MessageKey.SIGNATURE_JWT_ERROR;
                    }
                }
                setHttpServletRequestAttributes(httpServletRequest, headerMessage, userMessageKey, exception);
                throw new AccessDeniedException(headerMessage);
            }

            Map<String, ?> serializedAppUser = (Map<String, ?>) claims.get("appUser");
            List<GrantedAuthority> authorities = getGrantedAuthorities((List<Map<String, String>>) serializedAppUser.get("authorities"));

            AppUser appUser = new AppUser(Long.parseLong(serializedAppUser.get("id").toString()), serializedAppUser.get("email").toString(), null, serializedAppUser.get("firstName").toString(), serializedAppUser.get("lastName").toString(), authorities);
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(appUser, null, authorities);
        }
        return usernamePasswordAuthenticationToken;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Map<String, String>> serializedAuthorities) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Map<String, String> serializedAuthority : serializedAuthorities) {
            String authority = serializedAuthority.get("authority");
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }

    private <E extends Exception> void setHttpServletRequestAttributes(HttpServletRequest httpServletRequest, String headerMessage, MessageKey userMessageKey, E exception) {
        httpServletRequest.setAttribute(HEADER_MESSAGE, headerMessage);
        httpServletRequest.setAttribute(USER_MESSAGE_KEY, userMessageKey);
        httpServletRequest.setAttribute(DEVELOPER_MESSAGE, exception.getMessage());
    }

}
