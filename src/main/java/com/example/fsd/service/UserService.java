package com.example.fsd.service;

import com.example.fsd.dto.LoginDto;
import com.example.fsd.entity.User;
import com.example.fsd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

// this 2 are post method
//    {
//    to add single user
        @Autowired
        private UserRepository userRepository;
        public User saveUser(User user)
        {
            return userRepository.save(user);
        }

        public Optional<User> loginUser(LoginDto loginDto) {
                return userRepository.findByUsernameAndPassword(loginDto.username , loginDto.password);
        }

//    to add multiple users
//        public List<User> saveUsers (List < User > users)
//        {
//            return userRepository.saveAll(users);
//        }
//    }
//public List<User> getUsers()
//    {
//        return userRepository.findAll();
//    }
//    public User getUserById(int id)
//    {
//        return userRepository.findById(id).orElse( null);
//    }
//    public User getUserByName(String name)
//    {
//        return userRepository.findByName(name).orElse(null);
//    }
}
