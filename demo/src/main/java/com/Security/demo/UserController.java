package com.Security.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("user")
public class UserController {

    @ Autowired
    UserService userService;


    @PutMapping("/add")
    public Class<ResponseStatus> addUser(@RequestBody User user)
    {
        System.out.println("en");
  userService.createUser(user.getUsername(), user.getPassword());
        return ResponseStatus.class;
        
    }
    
}
