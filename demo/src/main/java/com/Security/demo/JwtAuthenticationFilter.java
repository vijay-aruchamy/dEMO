package com.Security.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Security.demo.AuthController.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

     @Autowired
    private PasswordEncoder passwordEncoder;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/login");
    }

   @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Deserialize the JSON request body to UserCredentials
            InputStream inputStream = request.getInputStream();
            ObjectMapper mapper = new ObjectMapper();

            UserCredentials userCredentials = mapper.readValue(inputStream, UserCredentials.class);
            System.out.println("Received authentication request for user: " + userCredentials.getUsername());
            // UserService userService=new UserService();
            // userService.changePass();

            // Create an authentication token with the provided username and password
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), passwordEncoder.encode(userCredentials.getPassword()));
                             
            // Perform authentication
            System.out.println("Authentication successful for user: " + userCredentials.getUsername());
            return authenticationManager.authenticate(authenticationToken);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        // Generate JWT token and add it to the response header
        String token = JwtUtils.generateToken(authResult.getName());
        response.addHeader("Authorization", "Bearer " + token);
    }
}
