package com.Security.demo;

import java.util.List;

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

    public void changePass() {
        

        List<User> users = userRepository.findAll();
    
       
        for (User user : users) {
            if (!passwordEncoder.matches("", user.getPassword())) {
                String plainPassword = user.getPassword(); 
                String encodedPassword = passwordEncoder.encode(plainPassword); 
                user.setPassword(encodedPassword); 
            }
        }
    
       
        userRepository.saveAll(users);
    }
}
    