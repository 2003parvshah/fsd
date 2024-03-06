package com.example.fsd.controller;

import com.example.fsd.dto.LoginDto;
import com.example.fsd.entity.User;
import com.example.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {
   @Autowired
   private UserService userService;



//    @PostMapping("register_user")
//    public User saveUser(@RequestBody User user)
//    {
//        return this.userService.saveUser(user);
//    }


//    @PostMapping("register_user")
//    public Map<String, Object> saveUser(@RequestBody User user) {
//        User savedUser = this.userService.saveUser(user);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("newdemo", "new value");
//        response.put("id", savedUser.getId());
//        response.put("name", savedUser.getName());
//        response.put("username", savedUser.getUsername());
//        response.put("password", savedUser.getPassword());
//        response.put("email", savedUser.getEmail());
//
//        return response;
//    }


    @PostMapping("register")
    public Map<String, Object> saveUser(@RequestBody User user) {
        User savedUser = this.userService.saveUser(user);

        Map<String, Object> response = new HashMap<>();
        response.put("newdemo", "best");

        // Iterate over the fields of the User object and add them to the response map
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Allow accessing private fields
            try {
                response.put(field.getName(), field.get(savedUser));
            } catch (IllegalAccessException e) {
                // Handle IllegalAccessException if needed
                e.printStackTrace();
            }
        }

        return response;
    }
    @PostMapping("login")
    public Optional<User> loginUser(@RequestBody LoginDto loginDto)
    {
        return userService.loginUser(loginDto);
    }
}
