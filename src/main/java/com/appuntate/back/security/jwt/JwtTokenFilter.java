package com.appuntate.back.security.jwt;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appuntate.back.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                try {
                    String token = getToken(request);

                    if(Objects.nonNull(token) && jwtProvider.validateToken(token)) {
                        String userName = jwtProvider.getUserNameFromToken(token);
                        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                        UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
                        
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }

                } catch(Exception e) {
                    System.out.println("PALABRA: " + e.getMessage());
                }

                filterChain.doFilter(request, response);
        
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if(Objects.nonNull(header) && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");

        return null;
    }
    
}
