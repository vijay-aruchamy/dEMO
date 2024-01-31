package com.Security.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    // ... other methods ...

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        // your existing code ...

        // Assuming UserCredentials class has getUsername() method
        String username = userCredentials.getUsername();
        System.out.println(username);
        // rest of your code...
        return username;
    }

    // UserCredentials class for receiving username and password from the client
    static class UserCredentials {
        private String username;
        private String password;

        // Constructors (default and parameterized) might be useful

        // Getter and setter methods
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

