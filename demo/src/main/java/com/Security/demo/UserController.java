package com.Security.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/emp")
public class UserController {

    @ Autowired
    UserService userService;


    @PostMapping("/create")
    public ResponseEntity<ResponseStatus> addUser(@RequestBody User user)
    {
          try {
        userService.createUser(user.getUsername(), user.getPassword());
        return (ResponseEntity<ResponseStatus>) ResponseEntity.ok();
    } catch (Exception e) {
       e.printStackTrace();
        return (ResponseEntity<ResponseStatus>) ResponseEntity.status(500);
        
    }
}
    
}
