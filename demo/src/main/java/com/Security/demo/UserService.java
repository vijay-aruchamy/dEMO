package com.Security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  

    @Autowired
    private UserRespository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUserName(String userName) {
        return userRepository.findByusername(userName);
    }

    public void createUser(String username, String plainPassword) {
        // Encode the plain password using BCrypt
        String encodedPassword = passwordEncoder.encode(plainPassword);
 System.out.println("entering");
        // Create a new user with the encoded password
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);
    }
}
